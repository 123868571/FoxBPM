/**
 * Copyright 1996-2014 FoxBPM ORG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * @author MAENLIANG
 */
package org.foxbpm.engine.impl.schedule.db;

import java.sql.Connection;

import org.foxbpm.engine.impl.util.DBUtils;
import org.quartz.JobPersistenceException;
import org.quartz.impl.jdbcjobstore.JobStoreTX;

/**
 * 
 * FoxbpmJobStore 集成流程引擎内部的数据库连接 MAENLIANG 2014年7月8日 上午11:17:02
 * 
 * @version 1.0.0
 * 
 */
public class FoxbpmJobStore extends JobStoreTX {
	 
	protected Connection getConnection() throws JobPersistenceException {
		Connection connection = DBUtils.getConnection();
		return connection;
	}
	
	 
	protected void closeConnection(Connection connection) {
		super.closeConnection(connection);
	}
	
	 
	protected void commitConnection(Connection connection) throws JobPersistenceException {
		super.commitConnection(connection);
	}
	
	 
	protected void rollbackConnection(Connection connection) {
		super.rollbackConnection(connection);
	}
}
