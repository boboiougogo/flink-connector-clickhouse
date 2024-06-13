/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.connector.clickhouse.internal.schema;

import javax.annotation.Nonnull;

import static org.apache.flink.util.Preconditions.checkArgument;
import static org.apache.flink.util.StringUtils.isNullOrWhitespaceOnly;

/** Column expression. */
public class FieldExpr extends Expression {

    private final String columnName;

    private FieldExpr(String columnName) {
        checkArgument(!isNullOrWhitespaceOnly(columnName), "columnName cannot be null or empty");
        this.columnName = columnName;
    }

    public static FieldExpr of(@Nonnull String columnName) {
        return new FieldExpr(columnName);
    }

    public String getColumnName() {
        return columnName;
    }

    @Override
    public String explain() {
        return columnName;
    }
}
