package com.example.ws;

import org.hibernate.dialect.PostgreSQL82Dialect;
import org.hibernate.type.descriptor.sql.LongVarcharTypeDescriptor;
import org.hibernate.type.descriptor.sql.SqlTypeDescriptor;

import java.sql.Types;

public class PostgreSQLDialectCustom extends PostgreSQL82Dialect {

    public PostgreSQLDialectCustom()
    {
        super();
        registerColumnType(Types.BLOB, "bytea");
    }

    @Override
    public SqlTypeDescriptor remapSqlTypeDescriptor(SqlTypeDescriptor sqlTypeDescriptor) {
        if (Types.CLOB == sqlTypeDescriptor.getSqlType()) {
            return LongVarcharTypeDescriptor.INSTANCE;
        }
        return super.remapSqlTypeDescriptor(sqlTypeDescriptor);
    }
}
