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

package org.datagear.persistence.support;

import org.datagear.persistence.PersistenceException;

/**
 * 表中没有定义任何列异常。
 * 
 * @author datagear@163.com
 *
 */
public class NoColumnDefinedException extends PersistenceException
{
	private static final long serialVersionUID = 1L;

	private String tableName;

	public NoColumnDefinedException(String tableName)
	{
		super();
		this.tableName = tableName;
	}

	public NoColumnDefinedException(String tableName, String message)
	{
		super(message);
		this.tableName = tableName;
	}

	public NoColumnDefinedException(String tableName, Throwable cause)
	{
		super(cause);
		this.tableName = tableName;
	}

	public NoColumnDefinedException(String tableName, String message, Throwable cause)
	{
		super(message, cause);
		this.tableName = tableName;
	}

	public String getTableName()
	{
		return tableName;
	}

	protected void setTableName(String tableName)
	{
		this.tableName = tableName;
	}
}
