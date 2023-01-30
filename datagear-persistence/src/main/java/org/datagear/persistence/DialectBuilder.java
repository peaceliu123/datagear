/*
 * Copyright 2018-2023 datagear.tech
 *
 * This file is part of DataGear.
 *
 * DataGear is free software: you can redistribute it and/or modify it under the terms of
 * the GNU Lesser General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 *
 * DataGear is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with DataGear.
 * If not, see <https://www.gnu.org/licenses/>.
 */

package org.datagear.persistence;

import java.sql.Connection;

import org.datagear.connection.ConnectionSensor;

/**
 * 数据库方言构建器。
 * 
 * @author datagear@163.com
 *
 */
public interface DialectBuilder extends ConnectionSensor
{
	/**
	 * 构建{@linkplain Dialect}。
	 * 
	 * @param cn
	 * @return
	 * @throws DialectException
	 */
	Dialect build(Connection cn) throws DialectException;
}
