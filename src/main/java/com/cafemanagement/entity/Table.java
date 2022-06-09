package com.cafemanagement.entity;

import com.cafemanagement.entity.states.TableState;

import javax.persistence.*;
import java.util.Objects;

@Entity
@javax.persistence.Table(name = "TABLES")
public final class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "table_sequence", sequenceName = "table_sequence")
    private Long id;
    @Column(name = "table_size", nullable = false)
    private Long tableSize;
    @Column(name = "table_state")
    @Enumerated(value = EnumType.STRING)
    private TableState state;

    public Table() {
    }

    public Table(Long tableSize, TableState state) {
        this.tableSize = tableSize;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public Long getTableSize() {
        return tableSize;
    }

    public void setTableSize(Long tableSize) {
        this.tableSize = tableSize;
    }

    public TableState getState() {
        return state;
    }

    public void setState(TableState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Table{" + "id=" + id + ", tableSize=" + tableSize + ", state=" + state + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Table table = (Table) o;
        return Objects.equals(id, table.id) && Objects.equals(tableSize, table.tableSize) && state == table.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tableSize, state);
    }
}
