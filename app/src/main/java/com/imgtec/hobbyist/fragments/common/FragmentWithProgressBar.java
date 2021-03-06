/*
 * Copyright (c) 2016, Imagination Technologies Limited and/or its affiliated group companies
 * and/or licensors
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted
 * provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions
 *     and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of
 *     conditions and the following disclaimer in the documentation and/or other materials provided
 *     with the distribution.
 *
 * 3. Neither the name of the copyright holder nor the names of its contributors may be used to
 *     endorse or promote products derived from this software without specific prior written
 *     permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY
 * WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */


package com.imgtec.hobbyist.fragments.common;

import android.app.ProgressDialog;
import android.os.Handler;

import com.imgtec.hobbyist.R;

import javax.inject.Inject;
import javax.inject.Named;

public abstract class FragmentWithProgressBar extends FragmentWithTitle {

  private ProgressDialog progressDialog;

  @Inject
  @Named("UI")
  protected Handler handler;

  protected void showProgress(final String message) {
    handler.post(new Runnable() {
      @Override
      public void run() {
        if (appContext != null && getActivity() != null) {
          progressDialog = ProgressDialog.show(getActivity(), appContext.getString(R.string.please_wait_with_dots), message, true);
          progressDialog.setCanceledOnTouchOutside(false);
        }
      }
    });
  }

  protected void hideProgress() {
    handler.post(new Runnable() {
      @Override
      public void run() {
        if (progressDialog != null) {
          progressDialog.dismiss();
        }
      }
    });
  }

  @Override
  public void onPause() {
    if (progressDialog != null) {
      progressDialog.dismiss();
    }
    super.onPause();
  }

}
