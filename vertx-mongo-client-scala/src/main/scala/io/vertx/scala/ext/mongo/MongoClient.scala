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

package io.vertx.scala.ext.mongo

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.ext.mongo.MongoClientDeleteResult
import io.vertx.ext.mongo.WriteOption
import io.vertx.scala.core.Vertx
import io.vertx.core.json.JsonArray
import io.vertx.ext.mongo.IndexOptions
import io.vertx.ext.mongo.FindOptions
import io.vertx.core.json.JsonObject
import io.vertx.core.Handler
import io.vertx.ext.mongo.MongoClientUpdateResult
import io.vertx.ext.mongo.UpdateOptions

/**
  * A Vert.x service used to interact with MongoDB server instances.
  * 
  * Some of the operations might change <i>_id</i> field of passed  document.
  */
class MongoClient(private val _asJava: io.vertx.ext.mongo.MongoClient) {

  def asJava: io.vertx.ext.mongo.MongoClient = _asJava

  /**
    * Save a document in the specified collection
    * 
    * This operation might change <i>_id</i> field of <i>document</i> parameter
    * @param collection the collection
    * @param document the document
    * @param resultHandler result handler will be provided with the id if document didn't already have one
    */
  def saveWithHandler(collection: String, document: io.vertx.core.json.JsonObject)( resultHandler: io.vertx.core.AsyncResult [String] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.save(collection, document, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.String], io.vertx.core.AsyncResult [String]](x => io.vertx.lang.scala.AsyncResult[java.lang.String, String](x,(x => x)))(resultHandler))
    this
  }

  /**
    * Save a document in the specified collection with the specified write option
    * 
    * This operation might change <i>_id</i> field of <i>document</i> parameter
    * @param collection the collection
    * @param document the document
    * @param writeOption the write option to use
    * @param resultHandler result handler will be provided with the id if document didn't already have one
    */
  def saveWithOptionsWithHandler(collection: String, document: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption)( resultHandler: io.vertx.core.AsyncResult [String] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.saveWithOptions(collection, document, writeOption, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.String], io.vertx.core.AsyncResult [String]](x => io.vertx.lang.scala.AsyncResult[java.lang.String, String](x,(x => x)))(resultHandler))
    this
  }

  /**
    * Insert a document in the specified collection
    * 
    * This operation might change <i>_id</i> field of <i>document</i> parameter
    * @param collection the collection
    * @param document the document
    * @param resultHandler result handler will be provided with the id if document didn't already have one
    */
  def insertWithHandler(collection: String, document: io.vertx.core.json.JsonObject)( resultHandler: io.vertx.core.AsyncResult [String] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.insert(collection, document, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.String], io.vertx.core.AsyncResult [String]](x => io.vertx.lang.scala.AsyncResult[java.lang.String, String](x,(x => x)))(resultHandler))
    this
  }

  /**
    * Insert a document in the specified collection with the specified write option
    * 
    * This operation might change <i>_id</i> field of <i>document</i> parameter
    * @param collection the collection
    * @param document the document
    * @param writeOption the write option to use
    * @param resultHandler result handler will be provided with the id if document didn't already have one
    */
  def insertWithOptionsWithHandler(collection: String, document: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption)( resultHandler: io.vertx.core.AsyncResult [String] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.insertWithOptions(collection, document, writeOption, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.String], io.vertx.core.AsyncResult [String]](x => io.vertx.lang.scala.AsyncResult[java.lang.String, String](x,(x => x)))(resultHandler))
    this
  }

  /**
    * Update matching documents in the specified collection
    * @param collection the collection
    * @param query query used to match the documents
    * @param update used to describe how the documents will be updated
    * @param resultHandler will be called when complete
    */
  def updateWithHandler(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject)( resultHandler: io.vertx.core.AsyncResult [Unit] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.update(collection, query, update, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Void], io.vertx.core.AsyncResult [Unit]](x => io.vertx.lang.scala.AsyncResult[java.lang.Void, Unit](x,(x => ())))(resultHandler))
    this
  }

  /**
    * Update matching documents in the specified collection and return the handler with MongoClientUpdateResult result
    * @param collection the collection
    * @param query query used to match the documents
    * @param update used to describe how the documents will be updated
    * @param resultHandler will be called when complete
    */
  def updateCollectionWithHandler(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject)( resultHandler: io.vertx.core.AsyncResult [io.vertx.scala.ext.mongo.MongoClientUpdateResult] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.updateCollection(collection, query, update, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult], io.vertx.core.AsyncResult [io.vertx.scala.ext.mongo.MongoClientUpdateResult]](x => io.vertx.lang.scala.AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult, io.vertx.scala.ext.mongo.MongoClientUpdateResult](x,(x => MongoClientUpdateResult(x))))(resultHandler))
    this
  }

  /**
    * Update matching documents in the specified collection, specifying options
    * @param collection the collection
    * @param query query used to match the documents
    * @param update used to describe how the documents will be updated
    * @param options options to configure the updatesee <a href="../../../../../../../cheatsheet/UpdateOptions.html">UpdateOptions</a>
    * @param resultHandler will be called when complete
    */
  def updateWithOptionsWithHandler(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject, options: io.vertx.scala.ext.mongo.UpdateOptions)( resultHandler: io.vertx.core.AsyncResult [Unit] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.updateWithOptions(collection, query, update, options.asJava, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Void], io.vertx.core.AsyncResult [Unit]](x => io.vertx.lang.scala.AsyncResult[java.lang.Void, Unit](x,(x => ())))(resultHandler))
    this
  }

  /**
    * Update matching documents in the specified collection, specifying options and return the handler with MongoClientUpdateResult result
    * @param collection the collection
    * @param query query used to match the documents
    * @param update used to describe how the documents will be updated
    * @param options options to configure the updatesee <a href="../../../../../../../cheatsheet/UpdateOptions.html">UpdateOptions</a>
    * @param resultHandler will be called when complete
    */
  def updateCollectionWithOptionsWithHandler(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject, options: io.vertx.scala.ext.mongo.UpdateOptions)( resultHandler: io.vertx.core.AsyncResult [io.vertx.scala.ext.mongo.MongoClientUpdateResult] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.updateCollectionWithOptions(collection, query, update, options.asJava, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult], io.vertx.core.AsyncResult [io.vertx.scala.ext.mongo.MongoClientUpdateResult]](x => io.vertx.lang.scala.AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult, io.vertx.scala.ext.mongo.MongoClientUpdateResult](x,(x => MongoClientUpdateResult(x))))(resultHandler))
    this
  }

  /**
    * Replace matching documents in the specified collection
    * 
    * This operation might change <i>_id</i> field of <i>replace</i> parameter
    * @param collection the collection
    * @param query query used to match the documents
    * @param replace all matching documents will be replaced with this
    * @param resultHandler will be called when complete
    */
  def replaceWithHandler(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject)( resultHandler: io.vertx.core.AsyncResult [Unit] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.replace(collection, query, replace, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Void], io.vertx.core.AsyncResult [Unit]](x => io.vertx.lang.scala.AsyncResult[java.lang.Void, Unit](x,(x => ())))(resultHandler))
    this
  }

  /**
    * Replace matching documents in the specified collection and return the handler with MongoClientUpdateResult result
    * @param collection the collection
    * @param query query used to match the documents
    * @param replace all matching documents will be replaced with this
    * @param resultHandler will be called when complete
    */
  def replaceDocumentsWithHandler(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject)( resultHandler: io.vertx.core.AsyncResult [io.vertx.scala.ext.mongo.MongoClientUpdateResult] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.replaceDocuments(collection, query, replace, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult], io.vertx.core.AsyncResult [io.vertx.scala.ext.mongo.MongoClientUpdateResult]](x => io.vertx.lang.scala.AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult, io.vertx.scala.ext.mongo.MongoClientUpdateResult](x,(x => MongoClientUpdateResult(x))))(resultHandler))
    this
  }

  /**
    * Replace matching documents in the specified collection, specifying options
    * 
    * This operation might change <i>_id</i> field of <i>replace</i> parameter
    * @param collection the collection
    * @param query query used to match the documents
    * @param replace all matching documents will be replaced with this
    * @param options options to configure the replacesee <a href="../../../../../../../cheatsheet/UpdateOptions.html">UpdateOptions</a>
    * @param resultHandler will be called when complete
    */
  def replaceWithOptionsWithHandler(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject, options: io.vertx.scala.ext.mongo.UpdateOptions)( resultHandler: io.vertx.core.AsyncResult [Unit] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.replaceWithOptions(collection, query, replace, options.asJava, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Void], io.vertx.core.AsyncResult [Unit]](x => io.vertx.lang.scala.AsyncResult[java.lang.Void, Unit](x,(x => ())))(resultHandler))
    this
  }

  /**
    * Replace matching documents in the specified collection, specifying options and return the handler with MongoClientUpdateResult result
    * @param collection the collection
    * @param query query used to match the documents
    * @param replace all matching documents will be replaced with this
    * @param options options to configure the replacesee <a href="../../../../../../../cheatsheet/UpdateOptions.html">UpdateOptions</a>
    * @param resultHandler will be called when complete
    */
  def replaceDocumentsWithOptionsWithHandler(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject, options: io.vertx.scala.ext.mongo.UpdateOptions)( resultHandler: io.vertx.core.AsyncResult [io.vertx.scala.ext.mongo.MongoClientUpdateResult] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.replaceDocumentsWithOptions(collection, query, replace, options.asJava, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult], io.vertx.core.AsyncResult [io.vertx.scala.ext.mongo.MongoClientUpdateResult]](x => io.vertx.lang.scala.AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult, io.vertx.scala.ext.mongo.MongoClientUpdateResult](x,(x => MongoClientUpdateResult(x))))(resultHandler))
    this
  }

  /**
    * Find matching documents in the specified collection
    * @param collection the collection
    * @param query query used to match documents
    * @param resultHandler will be provided with list of documents
    */
  def findWithHandler(collection: String, query: io.vertx.core.json.JsonObject)( resultHandler: io.vertx.core.AsyncResult [scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.find(collection, query, funcToMappedHandler[io.vertx.core.AsyncResult[java.util.List[io.vertx.core.json.JsonObject]], io.vertx.core.AsyncResult [scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]]](x => io.vertx.lang.scala.AsyncResult[java.util.List[io.vertx.core.json.JsonObject], scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]](x,x => if (x == null) null else x.asScala))(resultHandler))
    this
  }

  /**
    * Find matching documents in the specified collection.
    * This method use batchCursor for returning each found document.
    * @param collection the collection
    * @param query query used to match documents
    * @param resultHandler will be provided with each found document
    */
  def findBatchWithHandler(collection: String, query: io.vertx.core.json.JsonObject)( resultHandler: io.vertx.core.AsyncResult [io.vertx.core.json.JsonObject] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.findBatch(collection, query, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.core.json.JsonObject], io.vertx.core.AsyncResult [io.vertx.core.json.JsonObject]](x => io.vertx.lang.scala.AsyncResult[io.vertx.core.json.JsonObject, io.vertx.core.json.JsonObject](x,(x => x)))(resultHandler))
    this
  }

  /**
    * Find matching documents in the specified collection, specifying options
    * @param collection the collection
    * @param query query used to match documents
    * @param options options to configure the findsee <a href="../../../../../../../cheatsheet/FindOptions.html">FindOptions</a>
    * @param resultHandler will be provided with list of documents
    */
  def findWithOptionsWithHandler(collection: String, query: io.vertx.core.json.JsonObject, options: io.vertx.scala.ext.mongo.FindOptions)( resultHandler: io.vertx.core.AsyncResult [scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.findWithOptions(collection, query, options.asJava, funcToMappedHandler[io.vertx.core.AsyncResult[java.util.List[io.vertx.core.json.JsonObject]], io.vertx.core.AsyncResult [scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]]](x => io.vertx.lang.scala.AsyncResult[java.util.List[io.vertx.core.json.JsonObject], scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]](x,x => if (x == null) null else x.asScala))(resultHandler))
    this
  }

  /**
    * Find matching documents in the specified collection, specifying options.
    * This method use batchCursor for returning each found document.
    * @param collection the collection
    * @param query query used to match documents
    * @param options options to configure the findsee <a href="../../../../../../../cheatsheet/FindOptions.html">FindOptions</a>
    * @param resultHandler will be provided with each found document
    */
  def findBatchWithOptionsWithHandler(collection: String, query: io.vertx.core.json.JsonObject, options: io.vertx.scala.ext.mongo.FindOptions)( resultHandler: io.vertx.core.AsyncResult [io.vertx.core.json.JsonObject] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.findBatchWithOptions(collection, query, options.asJava, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.core.json.JsonObject], io.vertx.core.AsyncResult [io.vertx.core.json.JsonObject]](x => io.vertx.lang.scala.AsyncResult[io.vertx.core.json.JsonObject, io.vertx.core.json.JsonObject](x,(x => x)))(resultHandler))
    this
  }

  /**
    * Find a single matching document in the specified collection
    * 
    * This operation might change <i>_id</i> field of <i>query</i> parameter
    * @param collection the collection
    * @param query the query used to match the document
    * @param fields the fields
    * @param resultHandler will be provided with the document, if any
    */
  def findOneWithHandler(collection: String, query: io.vertx.core.json.JsonObject, fields: io.vertx.core.json.JsonObject)( resultHandler: io.vertx.core.AsyncResult [io.vertx.core.json.JsonObject] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.findOne(collection, query, fields, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.core.json.JsonObject], io.vertx.core.AsyncResult [io.vertx.core.json.JsonObject]](x => io.vertx.lang.scala.AsyncResult[io.vertx.core.json.JsonObject, io.vertx.core.json.JsonObject](x,(x => x)))(resultHandler))
    this
  }

  /**
    * Count matching documents in a collection.
    * @param collection the collection
    * @param query query used to match documents
    * @param resultHandler will be provided with the number of matching documents
    */
  def countWithHandler(collection: String, query: io.vertx.core.json.JsonObject)( resultHandler: io.vertx.core.AsyncResult [Long] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.count(collection, query, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Long], io.vertx.core.AsyncResult [Long]](x => io.vertx.lang.scala.AsyncResult[java.lang.Long, Long](x,(x => x)))(resultHandler))
    this
  }

  /**
    * Remove matching documents from a collection
    * @param collection the collection
    * @param query query used to match documents
    * @param resultHandler will be called when complete
    */
  def removeWithHandler(collection: String, query: io.vertx.core.json.JsonObject)( resultHandler: io.vertx.core.AsyncResult [Unit] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.remove(collection, query, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Void], io.vertx.core.AsyncResult [Unit]](x => io.vertx.lang.scala.AsyncResult[java.lang.Void, Unit](x,(x => ())))(resultHandler))
    this
  }

  /**
    * Remove matching documents from a collection and return the handler with MongoClientDeleteResult result
    * @param collection the collection
    * @param query query used to match documents
    * @param resultHandler will be called when complete
    */
  def removeDocumentsWithHandler(collection: String, query: io.vertx.core.json.JsonObject)( resultHandler: io.vertx.core.AsyncResult [io.vertx.scala.ext.mongo.MongoClientDeleteResult] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.removeDocuments(collection, query, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult], io.vertx.core.AsyncResult [io.vertx.scala.ext.mongo.MongoClientDeleteResult]](x => io.vertx.lang.scala.AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult, io.vertx.scala.ext.mongo.MongoClientDeleteResult](x,(x => MongoClientDeleteResult(x))))(resultHandler))
    this
  }

  /**
    * Remove matching documents from a collection with the specified write option
    * @param collection the collection
    * @param query query used to match documents
    * @param writeOption the write option to use
    * @param resultHandler will be called when complete
    */
  def removeWithOptionsWithHandler(collection: String, query: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption)( resultHandler: io.vertx.core.AsyncResult [Unit] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.removeWithOptions(collection, query, writeOption, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Void], io.vertx.core.AsyncResult [Unit]](x => io.vertx.lang.scala.AsyncResult[java.lang.Void, Unit](x,(x => ())))(resultHandler))
    this
  }

  /**
    * Remove matching documents from a collection with the specified write option and return the handler with MongoClientDeleteResult result
    * @param collection the collection
    * @param query query used to match documents
    * @param writeOption the write option to use
    * @param resultHandler will be called when complete
    */
  def removeDocumentsWithOptionsWithHandler(collection: String, query: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption)( resultHandler: io.vertx.core.AsyncResult [io.vertx.scala.ext.mongo.MongoClientDeleteResult] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.removeDocumentsWithOptions(collection, query, writeOption, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult], io.vertx.core.AsyncResult [io.vertx.scala.ext.mongo.MongoClientDeleteResult]](x => io.vertx.lang.scala.AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult, io.vertx.scala.ext.mongo.MongoClientDeleteResult](x,(x => MongoClientDeleteResult(x))))(resultHandler))
    this
  }

  /**
    * Remove a single matching document from a collection
    * @param collection the collection
    * @param query query used to match document
    * @param resultHandler will be called when complete
    */
  def removeOneWithHandler(collection: String, query: io.vertx.core.json.JsonObject)( resultHandler: io.vertx.core.AsyncResult [Unit] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.removeOne(collection, query, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Void], io.vertx.core.AsyncResult [Unit]](x => io.vertx.lang.scala.AsyncResult[java.lang.Void, Unit](x,(x => ())))(resultHandler))
    this
  }

  /**
    * Remove a single matching document from a collection and return the handler with MongoClientDeleteResult result
    * @param collection the collection
    * @param query query used to match document
    * @param resultHandler will be called when complete
    */
  def removeDocumentWithHandler(collection: String, query: io.vertx.core.json.JsonObject)( resultHandler: io.vertx.core.AsyncResult [io.vertx.scala.ext.mongo.MongoClientDeleteResult] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.removeDocument(collection, query, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult], io.vertx.core.AsyncResult [io.vertx.scala.ext.mongo.MongoClientDeleteResult]](x => io.vertx.lang.scala.AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult, io.vertx.scala.ext.mongo.MongoClientDeleteResult](x,(x => MongoClientDeleteResult(x))))(resultHandler))
    this
  }

  /**
    * Remove a single matching document from a collection with the specified write option
    * @param collection the collection
    * @param query query used to match document
    * @param writeOption the write option to use
    * @param resultHandler will be called when complete
    */
  def removeOneWithOptionsWithHandler(collection: String, query: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption)( resultHandler: io.vertx.core.AsyncResult [Unit] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.removeOneWithOptions(collection, query, writeOption, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Void], io.vertx.core.AsyncResult [Unit]](x => io.vertx.lang.scala.AsyncResult[java.lang.Void, Unit](x,(x => ())))(resultHandler))
    this
  }

  /**
    * Remove a single matching document from a collection with the specified write option and return the handler with MongoClientDeleteResult result
    * @param collection the collection
    * @param query query used to match document
    * @param writeOption the write option to use
    * @param resultHandler will be called when complete
    */
  def removeDocumentWithOptionsWithHandler(collection: String, query: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption)( resultHandler: io.vertx.core.AsyncResult [io.vertx.scala.ext.mongo.MongoClientDeleteResult] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.removeDocumentWithOptions(collection, query, writeOption, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult], io.vertx.core.AsyncResult [io.vertx.scala.ext.mongo.MongoClientDeleteResult]](x => io.vertx.lang.scala.AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult, io.vertx.scala.ext.mongo.MongoClientDeleteResult](x,(x => MongoClientDeleteResult(x))))(resultHandler))
    this
  }

  /**
    * Create a new collection
    * @param collectionName the name of the collection
    * @param resultHandler will be called when complete
    */
  def createCollectionWithHandler(collectionName: String)( resultHandler: io.vertx.core.AsyncResult [Unit] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.createCollection(collectionName, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Void], io.vertx.core.AsyncResult [Unit]](x => io.vertx.lang.scala.AsyncResult[java.lang.Void, Unit](x,(x => ())))(resultHandler))
    this
  }

  /**
    * Get a list of all collections in the database.
    * @param resultHandler will be called with a list of collections.
    */
  def getCollections(resultHandler: io.vertx.core.AsyncResult [scala.collection.mutable.Buffer[String]] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.getCollections(funcToMappedHandler[io.vertx.core.AsyncResult[java.util.List[java.lang.String]], io.vertx.core.AsyncResult [scala.collection.mutable.Buffer[String]]](x => io.vertx.lang.scala.AsyncResult[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x,x => if (x == null) null else x.asScala))(resultHandler))
    this
  }

  /**
    * Drop a collection
    * @param collection the collection
    * @param resultHandler will be called when complete
    */
  def dropCollectionWithHandler(collection: String)( resultHandler: io.vertx.core.AsyncResult [Unit] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.dropCollection(collection, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Void], io.vertx.core.AsyncResult [Unit]](x => io.vertx.lang.scala.AsyncResult[java.lang.Void, Unit](x,(x => ())))(resultHandler))
    this
  }

  /**
    * Creates an index.
    * @param collection the collection
    * @param key A document that contains the field and value pairs where the field is the index key and the value describes the type of index for that field. For an ascending index on a field, specify a value of 1; for descending index, specify a value of -1.
    * @param resultHandler will be called when complete
    */
  def createIndexWithHandler(collection: String, key: io.vertx.core.json.JsonObject)( resultHandler: io.vertx.core.AsyncResult [Unit] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.createIndex(collection, key, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Void], io.vertx.core.AsyncResult [Unit]](x => io.vertx.lang.scala.AsyncResult[java.lang.Void, Unit](x,(x => ())))(resultHandler))
    this
  }

  /**
    * Creates an index.
    * @param collection the collection
    * @param key A document that contains the field and value pairs where the field is the index key and the value describes the type of index for that field. For an ascending index on a field, specify a value of 1; for descending index, specify a value of -1.
    * @param options the options for the indexsee <a href="../../../../../../../cheatsheet/IndexOptions.html">IndexOptions</a>
    * @param resultHandler will be called when complete
    */
  def createIndexWithOptionsWithHandler(collection: String, key: io.vertx.core.json.JsonObject, options: io.vertx.scala.ext.mongo.IndexOptions)( resultHandler: io.vertx.core.AsyncResult [Unit] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.createIndexWithOptions(collection, key, options.asJava, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Void], io.vertx.core.AsyncResult [Unit]](x => io.vertx.lang.scala.AsyncResult[java.lang.Void, Unit](x,(x => ())))(resultHandler))
    this
  }

  /**
    * Get all the indexes in this collection.
    * @param collection the collection
    * @param resultHandler will be called when complete
    */
  def listIndexesWithHandler(collection: String)( resultHandler: io.vertx.core.AsyncResult [io.vertx.core.json.JsonArray] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.listIndexes(collection, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.core.json.JsonArray], io.vertx.core.AsyncResult [io.vertx.core.json.JsonArray]](x => io.vertx.lang.scala.AsyncResult[io.vertx.core.json.JsonArray, io.vertx.core.json.JsonArray](x,(x => x)))(resultHandler))
    this
  }

  /**
    * Drops the index given its name.
    * @param collection the collection
    * @param indexName the name of the index to remove
    * @param resultHandler will be called when complete
    */
  def dropIndexWithHandler(collection: String, indexName: String)( resultHandler: io.vertx.core.AsyncResult [Unit] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.dropIndex(collection, indexName, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Void], io.vertx.core.AsyncResult [Unit]](x => io.vertx.lang.scala.AsyncResult[java.lang.Void, Unit](x,(x => ())))(resultHandler))
    this
  }

  /**
    * Run an arbitrary MongoDB command.
    * @param commandName the name of the command
    * @param command the command
    * @param resultHandler will be called with the result.
    */
  def runCommandWithHandler(commandName: String, command: io.vertx.core.json.JsonObject)( resultHandler: io.vertx.core.AsyncResult [io.vertx.core.json.JsonObject] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.runCommand(commandName, command, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.core.json.JsonObject], io.vertx.core.AsyncResult [io.vertx.core.json.JsonObject]](x => io.vertx.lang.scala.AsyncResult[io.vertx.core.json.JsonObject, io.vertx.core.json.JsonObject](x,(x => x)))(resultHandler))
    this
  }

  /**
    * Gets the distinct values of the specified field name.
    * Return a JsonArray containing distinct values (eg: [ 1 , 89 ])
    * @param collection the collection
    * @param fieldName the field name
    * @param resultHandler will be provided with array of values.
    */
  def distinctWithHandler(collection: String, fieldName: String, resultClassname: String)( resultHandler: io.vertx.core.AsyncResult [io.vertx.core.json.JsonArray] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.distinct(collection, fieldName, resultClassname, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.core.json.JsonArray], io.vertx.core.AsyncResult [io.vertx.core.json.JsonArray]](x => io.vertx.lang.scala.AsyncResult[io.vertx.core.json.JsonArray, io.vertx.core.json.JsonArray](x,(x => x)))(resultHandler))
    this
  }

  /**
    * Gets the distinct values of the specified field name.
    * This method use batchCursor for returning each found value.
    * Each value is a json fragment with fieldName key (eg: {"num": 1`).
    * @param collection the collection
    * @param fieldName the field name
    * @param resultHandler will be provided with each found value
    */
  def distinctBatchWithHandler(collection: String, fieldName: String, resultClassname: String)( resultHandler: io.vertx.core.AsyncResult [io.vertx.core.json.JsonObject] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.distinctBatch(collection, fieldName, resultClassname, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.core.json.JsonObject], io.vertx.core.AsyncResult [io.vertx.core.json.JsonObject]](x => io.vertx.lang.scala.AsyncResult[io.vertx.core.json.JsonObject, io.vertx.core.json.JsonObject](x,(x => x)))(resultHandler))
    this
  }

  /**
    * Close the client and release its resources
    */
  def close(): Unit = {
    _asJava.close()
  }

}

object MongoClient {

  def apply(_asJava: io.vertx.ext.mongo.MongoClient): io.vertx.scala.ext.mongo.MongoClient =
    new io.vertx.scala.ext.mongo.MongoClient(_asJava)
  def createNonShared(vertx: io.vertx.scala.core.Vertx, config: io.vertx.core.json.JsonObject): io.vertx.scala.ext.mongo.MongoClient = {
    MongoClient.apply(io.vertx.ext.mongo.MongoClient.createNonShared(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], config))
  }
  def createShared(vertx: io.vertx.scala.core.Vertx, config: io.vertx.core.json.JsonObject, dataSourceName: String): io.vertx.scala.ext.mongo.MongoClient = {
    MongoClient.apply(io.vertx.ext.mongo.MongoClient.createShared(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], config, dataSourceName))
  }
  def createShared(vertx: io.vertx.scala.core.Vertx, config: io.vertx.core.json.JsonObject): io.vertx.scala.ext.mongo.MongoClient = {
    MongoClient.apply(io.vertx.ext.mongo.MongoClient.createShared(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], config))
  }
}
