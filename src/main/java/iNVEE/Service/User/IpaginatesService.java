package iNVEE.Service.User;

import org.springframework.stereotype.Service;

import iNVEE.Dto.PaginatesDto;

@Service
public interface IpaginatesService {
public PaginatesDto GetInfoPaginates(Integer totalData, Integer limit, Integer currentPage);
}
