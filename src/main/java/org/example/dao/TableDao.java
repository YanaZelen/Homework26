package org.example.dao;

import org.example.entity.CafeTable;

import java.util.List;

public interface TableDao {

    void saveTable(int numberOfTable);

    List<CafeTable> getAllTable();

    CafeTable getTableById(long id);

}
