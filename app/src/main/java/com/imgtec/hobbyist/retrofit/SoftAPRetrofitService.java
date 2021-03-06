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
package com.imgtec.hobbyist.retrofit;


import com.imgtec.hobbyist.retrofit.pojos.softap.DeviceInfo;
import com.imgtec.hobbyist.retrofit.pojos.softap.DeviceName;
import com.imgtec.hobbyist.retrofit.pojos.softap.DeviceServer;
import com.imgtec.hobbyist.retrofit.pojos.softap.NetworkConfig;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface SoftAPRetrofitService {

  @GET("device")
  Call<DeviceInfo> getDeviceInfo();

  @GET("name")
  Call<DeviceName> getDeviceName();

  @POST("reboot")
  Call<Void> rebootDevice();

  @POST("rebootsoftap")
  Call<Void> rebootDeviceIntoSoftAP();

  @POST("name")
  Call<Void> setDeviceName(@Body DeviceName deviceName);

  @POST("network")
  Call<Void> setNetworkConfig(@Body NetworkConfig networkConfig);

  @POST("deviceserver")
  Call<Void> setDeviceServer(@Body DeviceServer deviceServer);

  @POST("factoryreset")
  Call<Void> factoryReset(@Body NetworkConfig networkConfig);

}
