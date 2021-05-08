package com.albanero.homeassignment.Service;

import com.albanero.homeassignment.Entity.ColumnInfo;
import com.albanero.homeassignment.Entity.TableInfo;
import com.albanero.homeassignment.Repository.TableInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.albanero.homeassignment.Constant.Constant.*;

@Service
public class EmployeeService {

    private static final String SELECT_QUERY = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'test'";

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private TableInfoRepository tableInfoRepository;

    /**
     * Get metadata from database and saving it to database
     */
    public void extractAndProcessMetadata() {
        List<String> tableList = entityManager.createNativeQuery(SELECT_QUERY).getResultList();
        if (!CollectionUtils.isEmpty(tableList)) {
            tableList.forEach(e -> {
                String DESCRIBE_QUERY = DESCRIBE + e;
                List<Object[]> result = entityManager.createNativeQuery(DESCRIBE_QUERY).getResultList();
                if (!e.equals(COLUMN_INFO) && !e.equals(TABLE_INFO)) {
                    TableInfo tableInfo = new TableInfo();
                    tableInfo.setTableName(e);
                    result.forEach(r -> {
                        ColumnInfo columnInfo = new ColumnInfo();
                        columnInfo.setColumnName((String) r[0]);
                        columnInfo.setColumnType((String) r[1]);
                        columnInfo.setTableInfo(tableInfo);
                        tableInfo.getColumnInfoList().add(columnInfo);
                    });
                    tableInfoRepository.save(tableInfo);
                }
            });
        }
    }
}
