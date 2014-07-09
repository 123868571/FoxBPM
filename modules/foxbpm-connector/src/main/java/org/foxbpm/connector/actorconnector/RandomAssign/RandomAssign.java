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
 * @author yangguangftlp
 */
package org.foxbpm.connector.actorconnector.RandomAssign;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.foxbpm.connector.common.constant.Constants;
import org.foxbpm.engine.exception.FoxBPMConnectorException;
import org.foxbpm.engine.impl.connector.ActorConnectorHandler;
import org.foxbpm.engine.impl.util.StringUtil;
import org.foxbpm.engine.task.DelegateTask;

/**
 * 随机分配任务
 * 
 * @author yangguangftlp
 * @date 2014年7月7日
 */
public class RandomAssign extends ActorConnectorHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 325047500772052099L;
	private java.lang.String userId;

	public void assign(DelegateTask task) throws Exception {
		if (StringUtil.isEmpty(StringUtil.trim(userId))) {
			throw new FoxBPMConnectorException("userId is null!");
		}
		// 获取待分配的用户
		List<String> userIds = Arrays.asList(StringUtil.trim(userId).split(Constants.COMMA));
		if (userIds.size() == 1) {
			task.setAssignee(StringUtil.trim(userId));
		} else {
			// 随机产生
			Random random = new Random();
			int index = random.nextInt(userIds.size());
			task.setAssignee(StringUtil.trim(userIds.get(index)));
		}

	}

	public void setUserId(java.lang.String userId) {
		this.userId = userId;
	}

}