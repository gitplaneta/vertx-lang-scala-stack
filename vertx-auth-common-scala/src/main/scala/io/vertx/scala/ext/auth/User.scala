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
  * Represents an authenticates User and contains operations to authorise the user.
  * 
  * Please consult the documentation for a detailed explanation.
  */
class User(private val _asJava: io.vertx.ext.auth.User) {

  def asJava: io.vertx.ext.auth.User = _asJava

  /**
    * Is the user authorised to
    * @param authority the authority - what this really means is determined by the specific implementation. It might represent a permission to access a resource e.g. `printers:printer34` or it might represent authority to a role in a roles based model, e.g. `role:admin`.
    * @param resultHandler handler that will be called with an [[io.vertx.scala.core.AsyncResult]] containing the value `true` if the they has the authority or `false` otherwise.
    * @return the User to enable fluent use
    */
  def isAuthorisedWithHandler(authority: String)( resultHandler: io.vertx.core.AsyncResult [Boolean] => Unit): io.vertx.scala.ext.auth.User = {
    _asJava.isAuthorised(authority, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Boolean], io.vertx.core.AsyncResult [Boolean]](x => io.vertx.lang.scala.AsyncResult[java.lang.Boolean, Boolean](x,(x => x)))(resultHandler))
    this
  }

  /**
    * The User object will cache any authorities that it knows it has to avoid hitting the
    * underlying auth provider each time.  Use this method if you want to clear this cache.
    * @return the User to enable fluent use
    */
  def clearCache(): io.vertx.scala.ext.auth.User = {
    _asJava.clearCache()
    this
  }

  /**
    * Get the underlying principal for the User. What this actually returns depends on the implementation.
    * For a simple user/password based auth, it's likely to contain a JSON object with the following structure:
    * <pre>
    *   {
    *     "username", "tim"
    *   `
    * </pre>
    * @return JSON representation of the Principal
    */
  def principal(): io.vertx.core.json.JsonObject = {
    _asJava.principal()
  }

  /**
    * Set the auth provider for the User. This is typically used to reattach a detached User with an AuthProvider, e.g.
    * after it has been deserialized.
    * @param authProvider the AuthProvider - this must be the same type of AuthProvider that originally created the User
    */
  def setAuthProvider(authProvider: io.vertx.scala.ext.auth.AuthProvider): Unit = {
    _asJava.setAuthProvider(authProvider.asJava.asInstanceOf[io.vertx.ext.auth.AuthProvider])
  }

}

object User {

  def apply(_asJava: io.vertx.ext.auth.User): io.vertx.scala.ext.auth.User =
    new io.vertx.scala.ext.auth.User(_asJava)
}
