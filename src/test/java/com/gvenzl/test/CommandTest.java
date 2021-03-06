/*
 * Since: October, 2013
 * Author: gvenzl
 * Name: CommandTest.java
 * Description:
 *
 * Copyright 2018 Gerald Venzl
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gvenzl.test;

import oracle.kv.Key;
import oracle.kv.Value;

import org.junit.Assert;
import org.junit.Test;

import com.gvenzl.commands.Command;

public class CommandTest {

	private final String command = "select test from dual";
	private final Key key = Key.createKey("MajorKey", "minorKey");
	private final Value value = Value.createValue("This is my cool test value".getBytes());
	
	@Test
	public void test_ConstrutorString() {		
		Command cmd = new Command(command);
		Assert.assertEquals(Command.TYPE.SQL, cmd.getType());
		Assert.assertEquals(command, cmd.getCommand());
	}
	
	@Test
	public void test_ConstructorKeyValue() {
		Command cmd = new Command(key, value);
		Assert.assertEquals(Command.TYPE.KV, cmd.getType());
		Assert.assertEquals(key, cmd.getKey());
		Assert.assertEquals(value, cmd.getValue());
	}
	
	@Test
	public void test_getCommand() {
		Assert.assertEquals(command, new Command(command).getCommand());
	}
	
	@Test
	public void test_getKey() {
		Assert.assertEquals(key, new Command(key, null).getKey());
	}
	
	@Test
	public void test_getValue() {
		Assert.assertEquals(value, new Command(null, value).getValue());
	}
	
}
