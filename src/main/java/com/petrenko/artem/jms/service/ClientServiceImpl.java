package com.petrenko.artem.jms.service;

import com.petrenko.artem.jms.data.ClientData;
import com.petrenko.artem.jms.dto.ClientDetailsDto;
import com.petrenko.artem.jms.dto.ClientInfoDto;
import com.petrenko.artem.jms.dto.ClientQueryDto;
import com.petrenko.artem.jms.dto.ClientSaveDto;
import com.petrenko.artem.jms.dto.PageDto;
import com.petrenko.artem.jms.exceptions.NotFoundException;
import com.petrenko.artem.jms.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

  private final ClientRepository clientRepository;

  @Override
  public String createClient(ClientSaveDto dto) {
    validateClient(dto);
    ClientData data = new ClientData();
    updateDataFromDto(data, dto);
    ClientData saved = clientRepository.save(data);
    return saved.getId();
  }

  private static void validateClient(ClientSaveDto dto) {
    if (dto.getBirthDate() != null && dto.getBirthDate().isAfter(LocalDate.now())) {
      throw new IllegalArgumentException("birthDate should be before now");
    }
    // TODO add contact info validation
  }

  private void updateDataFromDto(ClientData data, ClientSaveDto dto) {
    data.setFirstName(dto.getFirstName());
    data.setLastName(dto.getLastName());
    data.setContactInfo(dto.getContactInfo());
  }

  private ClientData getOrThrow(String id) {
    return clientRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Client with id '%d' not found".formatted(id)));
  }

  @Override
  public ClientDetailsDto getClient(String id) {
    ClientData data = getOrThrow(id);
    return convertToDetails(data);
  }

  private ClientDetailsDto convertToDetails(ClientData data) {
    return ClientDetailsDto.builder()
        .id(data.getId())
        .firstName(data.getFirstName())
        .lastName(data.getLastName())
        .contactInfo(data.getContactInfo())
        .build();
  }

  @Override
  public void updateClient(String id, ClientSaveDto dto) {
    validateClient(dto);
    ClientData data = getOrThrow(id);
    updateDataFromDto(data, dto);
    clientRepository.save(data);
  }

  @Override
  public PageDto<ClientInfoDto> search(ClientQueryDto query) {
    Page<ClientData> page = clientRepository.search(query);
    return PageDto.fromPage(page, this::toInfoDto);
  }

  private ClientInfoDto toInfoDto(ClientData data) {
    return ClientInfoDto.builder()
        .id(data.getId())
        .fullName(data.getFirstName() + " " + data.getLastName())
        .build();
  }
}
