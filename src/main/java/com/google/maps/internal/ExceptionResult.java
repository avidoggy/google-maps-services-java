/*
 * Copyright 2014 Google Inc. All rights reserved.
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF
 * ANY KIND, either express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.google.maps.internal;

import com.google.maps.PendingResult;
import com.squareup.okhttp.MediaType;

/**
 * This class centralizes failure handling, independent of the calling style.
 */
public class ExceptionResult<T> implements PendingResult<T> {

  private final Exception exception;

  public ExceptionResult(Exception exception) {
    this.exception = exception;
  }

  @Override
  public final void setMethod(MethodType methodType, MediaType contentType) {
    // TODO 
  }

  @Override
  public void setCallback(Callback<T> callback) {
    callback.onFailure(exception);
  }

  @Override
  public T await() throws Exception {
    throw exception;
  }

  @Override
  public T awaitIgnoreError() {
    return null;
  }

  @Override
  public void cancel() {
  }
}
