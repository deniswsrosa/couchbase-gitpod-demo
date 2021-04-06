package com.example.demo.repositories;

import com.example.demo.entities.Building;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.data.couchbase.repository.ScanConsistency;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import static com.couchbase.client.java.query.QueryScanConsistency.REQUEST_PLUS;

import java.util.List;
public interface BuildingRepository extends CrudRepository<Building, String> {

    List<Building> findByCompanyId(String companyId);

    @ScanConsistency(query = REQUEST_PLUS)
    Page<Building> findByCompanyIdAndNameLikeOrderByName(String companyId, String name, Pageable pageable);

    @ScanConsistency(query = REQUEST_PLUS)
    @Query("#{#n1ql.selectEntity} where #{#n1ql.filter} and companyId = $1 and $2 within #{#n1ql.bucket}")
    Building findByCompanyAndAreaId(String companyId, String areaId);

    @ScanConsistency(query = REQUEST_PLUS)
    @Query("#{#n1ql.selectEntity} where #{#n1ql.filter} AND ANY phone IN phoneNumbers SATISFIES phone = $1 END")
    List<Building> findByPhoneNumber(String telephoneNumber);

    @ScanConsistency(query = REQUEST_PLUS)
    @Query("SELECT COUNT(*) AS count FROM #{#n1ql.bucket} WHERE #{#n1ql.filter} and companyId = $1")
    Long countBuildings(String companyId);
}
