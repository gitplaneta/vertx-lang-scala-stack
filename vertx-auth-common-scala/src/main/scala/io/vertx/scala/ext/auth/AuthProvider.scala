/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.vertx.scala.ext.auth

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.Handler

/**
  *
  * User-facing interface for authenticating users.
  */
class AuthProvider(private val _asJava: io.vertx.ext.auth.AuthProvider) {

  def asJava: io.vertx.ext.auth.AuthProvider = _asJava

  /**
    * Authenticate a user.
    * 
    * The first argument is a JSON object containing information for authenticating the user. What this actually contains
    * depends on the specific implementation. In the case of a simple username/password based
    * authentication it is likely to contain a JSON object with the following structure:
    * <pre>
    *   {
    *     "username": "tim",
    *     "password": "mypassword"
    *   `
    * </pre>
    * For other types of authentication it contain different information - for example a JWT token or OAuth bearer token.
    * 
    * If the user is successfully authenticated a [[io.vertx.scala.ext.auth.User]] object is passed to the handler in an [[io.vertx.scala.core.AsyncResult]].
    * The user object can then be used for authorisation.
    * @param authInfo The auth information
    * @param resultHandler The result handler
    */
  def authenticateWithHandler(authInfo: io.vertx.core.json.JsonObject)( resultHandler: io.vertx.core.AsyncResult [io.vertx.scala.ext.auth.User] => Unit): Unit = {
    _asJava.authenticate(authInfo, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.ext.auth.User], io.vertx.core.AsyncResult [io.vertx.scala.ext.auth.User]](x => io.vertx.lang.scala.AsyncResult[io.vertx.ext.auth.User, io.vertx.scala.ext.auth.User](x,(x => if (x == null) null else User.apply(x))))(resultHandler))
  }

}

object AuthProvider {

  def apply(_asJava: io.vertx.ext.auth.AuthProvider): io.vertx.scala.ext.auth.AuthProvider =
    new io.vertx.scala.ext.auth.AuthProvider(_asJava)
}
