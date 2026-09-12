package com.tmc.network;

import android.content.Context;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.cloud.tmc.component_api_ps.ipc.constants.MiniAppIpcConfig;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.google.gson.Gson;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.tmc.network.strategy.d;
import com.transsion.api.gateway.GateWaySdk;
import com.transsion.api.gateway.config.WorkMode;
import com.vungle.ads.internal.f;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\b\b\u0016\u0018\u0000 N2\u00020\u0001:\u0002NOB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J4\u0010\u0011\u001a\u00020\u00122\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014H\u0002JZ\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0006\u0010\u001a\u001a\u00020\u001bJX\u0010\u0016\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u00042\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0006\u0010\u001a\u001a\u00020\u001dJL\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bJJ\u0010\u0016\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u00042\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001dJ/\u0010\u001f\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0086\u0002J-\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u00042\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00142\u0006\u0010\u001a\u001a\u00020\u001dH\u0086\u0002JG\u0010\u001f\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0086\u0002JE\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u00042\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0006\u0010\u001a\u001a\u00020\u001dH\u0086\u0002J\u0017\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010#J\u001c\u0010$\u001a\u00020%2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0014H\u0002J\u001e\u0010&\u001a\u00020'2\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014H\u0002J\u0006\u0010(\u001a\u00020\bJ(\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010\u0018\u001a\u00020\u00042\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014H\u0002J\u0014\u0010+\u001a\u0004\u0018\u00010\u00122\b\u0010,\u001a\u0004\u0018\u00010\u0001H\u0002J\u001c\u0010-\u001a\u00020.2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0014H\u0002J\u001a\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u000102H\u0002JD\u00103\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0006\u0010\u001a\u001a\u00020\u001bJ2\u00104\u001a\u00020\u001c2\b\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u00108\u001a\u0004\u0018\u0001092\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;J<\u00104\u001a\u00020\u001c2\b\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u00108\u001a\u0004\u0018\u0001092\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;2\b\b\u0002\u0010<\u001a\u00020\nJZ\u0010=\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0006\u0010\u001a\u001a\u00020\u001bJX\u0010=\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u00042\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0006\u0010\u001a\u001a\u00020\u001dJN\u0010=\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0002JL\u0010=\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u00042\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001dH\u0002JP\u0010>\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\b\u0010,\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001a\u001a\u00020\u001bH\u0007JN\u0010>\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u00042\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\b\u0010,\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001a\u001a\u00020\u001dH\u0007J\\\u0010?\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0014\u0010@\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0007JZ\u0010?\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u00042\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0014\u0010@\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0006\u0010\u001a\u001a\u00020\u001dH\u0007JN\u0010A\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0007JL\u0010A\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u00042\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001dH\u0007JZ\u0010B\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0006\u0010\u001a\u001a\u00020\u001bJZ\u0010C\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0006\u0010\u001a\u001a\u00020\u001bJX\u0010C\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u00042\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0006\u0010\u001a\u001a\u00020\u001dJL\u0010C\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bJJ\u0010C\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u00042\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001dJ\u001e\u0010D\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010E\u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u00020\u0004J\"\u0010F\u001a\u00020\u001c2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00040H2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00040HJ\u000e\u0010J\u001a\u00020\u001c2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010K\u001a\u00020\u001c2\u0006\u0010L\u001a\u00020\nJ\u000e\u0010M\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lcom/tmc/network/HttpRequestor;", "", "()V", MiniAppIpcConfig.IPC_ADDHOME_APP_NAME, "", TmcStartParams.KEY_APP_VERSION, PlaceTypes.COUNTRY, "httpClient", "Lcom/tmc/network/HttpClient;", "ifCommonHeader", "", "ifGatewayAlwaysAccess", "isInit", "Ljava/util/concurrent/atomic/AtomicBoolean;", TmcConstants.KEY_LANGUAGE, "versionCode", "", "buildRequestBody", "Lokhttp3/RequestBody;", "headers", "", "formData", RequestParameters.SUBRESOURCE_DELETE, "Lokhttp3/Call;", "url", "params", "callback", "Lcom/tmc/network/INetworkCallback;", "", "Lokhttp3/Callback;", "requestBody", "get", "getCallTimeout", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "(Ljava/lang/String;)Ljava/lang/Long;", "getFormBody", "Lokhttp3/FormBody;", "getHeaders", "Lokhttp3/Headers;", "getHttpClient", "getHttpUrl", "Lokhttp3/HttpUrl;", "getJSONBody", "json", "getMultipartBody", "Lokhttp3/MultipartBody;", "getRawBody", "content", NativeComponentConstants.KEY_COMPONENT_TYPE, "Lokhttp3/MediaType;", TtmlNode.TAG_HEAD, "init", "context", "Landroid/content/Context;", "appId", "workMode", "Lcom/transsion/api/gateway/config/WorkMode;", "progressListener", "Lcom/tmc/network/ProgressListener;", "isNetworkMonitorEnable", "post", "postJSON", "postMultipart", "multipartData", "postRequestBody", "postV2", "put", "setAppInfo", "setCountry", "setGateWayActivateSignConfig", "hostList", "", "pathList", "setGatewayAlwaysAccess", "setIfCommonHeader", "commonHeader", "setLanguage", "Companion", "HttpRequestorHolder", "network_release"}, k = 1, mv = {1, 5, 1}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public class HttpRequestor {
    private static final String CALL_TIMEOUT = "m-timeout";
    private static final long MAX_CALL_TIMEOUT = 90000;
    private boolean ifGatewayAlwaysAccess;
    private int versionCode;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String ENCODING = "UTF-8";
    private static final String CONTENT_TYPE = HttpHeaders.CONTENT_TYPE;
    private static final String TIME_ZONE = "Accept-Timezone";
    private static final String LANGUAGE = "Accept-Language";
    private static final String COUNTRY = "Accept-Country";
    private static final String GATEWAY_ALWAYS_ACCESS = "x-tr-region";
    private static final String APP_NAME = MiniAppIpcConfig.IPC_ADDHOME_APP_NAME;
    private static final String APP_VERSION = TmcStartParams.KEY_APP_VERSION;
    private static final String VERSION_CODE = "versionCode";
    private static boolean enablePostMode = true;
    private boolean ifCommonHeader = true;
    private String appName = "";
    private String appVersion = "";
    private String language = "";
    private String country = "";
    private final HttpClient httpClient = new HttpClient(null, 1, 0 == true ? 1 : 0);
    private final AtomicBoolean isInit = new AtomicBoolean(false);

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0011J\u000e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/tmc/network/HttpRequestor$Companion;", "", "()V", f.TOKEN_APP_NAME, "", "APP_VERSION", "CALL_TIMEOUT", "CONTENT_TYPE", "COUNTRY", "ENCODING", "GATEWAY_ALWAYS_ACCESS", "LANGUAGE", "MAX_CALL_TIMEOUT", "", "TIME_ZONE", "VERSION_CODE", "enablePostMode", "", "getInstance", "Lcom/tmc/network/HttpRequestor;", "setCacheMode", "", "ifUseCache", "ifForce", "setLoggable", "loggable", "setPostMode", OfflineConstantsKt.OFFLINE_CONFIG_ENABLE, "network_release"}, k = 1, mv = {1, 5, 1}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HttpRequestor getInstance() {
            return HttpRequestorHolder.INSTANCE.getSInstance();
        }

        public final void setCacheMode(boolean ifUseCache, boolean ifForce) {
            HttpClient.INSTANCE.setCacheMode(ifUseCache, ifForce);
        }

        public final void setLoggable(boolean loggable) {
            gg.b.f63690a.h(loggable);
        }

        public final void setPostMode(boolean r12) {
            HttpRequestor.enablePostMode = r12;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/tmc/network/HttpRequestor$HttpRequestorHolder;", "", "()V", "sInstance", "Lcom/tmc/network/HttpRequestor;", "getSInstance", "()Lcom/tmc/network/HttpRequestor;", "network_release"}, k = 1, mv = {1, 5, 1}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes5.dex */
    public static final class HttpRequestorHolder {
        public static final HttpRequestorHolder INSTANCE = new HttpRequestorHolder();
        private static final HttpRequestor sInstance = new HttpRequestor();

        private HttpRequestorHolder() {
        }

        public HttpRequestor getSInstance() {
            return sInstance;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected HttpRequestor() {
    }

    private final RequestBody buildRequestBody(Map<String, String> headers, Map<String, String> formData) {
        Map<String, String> h11 = formData == null ? MapsKt.h() : formData;
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (StringsKt.H(CONTENT_TYPE, key, true)) {
                    if (StringsKt.c0(value, "application/x-www-form-urlencoded", false, 2, null)) {
                        Intrinsics.e(formData);
                        return getFormBody(formData);
                    }
                    if (StringsKt.c0(value, "multipart/form-data", false, 2, null)) {
                        Intrinsics.e(formData);
                        return getMultipartBody(formData);
                    }
                    RequestBody.Companion companion = RequestBody.INSTANCE;
                    String json = new Gson().toJson(h11);
                    Intrinsics.g(json, "Gson().toJson(data)");
                    return companion.create(json, MediaType.INSTANCE.parse(value));
                }
            }
        }
        Intrinsics.e(formData);
        return getFormBody(formData);
    }

    private final FormBody getFormBody(Map<String, String> params) {
        FormBody.Builder builder = new FormBody.Builder(Charset.forName(ENCODING));
        if (gg.a.f63688a.c(params)) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                builder.add(entry.getKey(), entry.getValue());
            }
        }
        return builder.build();
    }

    private final Headers getHeaders(Map<String, String> headers) {
        if (headers == null) {
            headers = new HashMap<>();
        }
        if (!this.ifCommonHeader) {
            return new Headers.Builder().build();
        }
        String str = TIME_ZONE;
        gg.a aVar = gg.a.f63688a;
        headers.put(str, aVar.a());
        if (this.ifGatewayAlwaysAccess) {
            headers.put(GATEWAY_ALWAYS_ACCESS, "CN");
        }
        if (!aVar.b(this.appName)) {
            headers.put(APP_NAME, this.appName);
        }
        if (!aVar.b(this.appVersion)) {
            headers.put(APP_VERSION, this.appVersion);
        }
        int i11 = this.versionCode;
        if (i11 > 0) {
            headers.put(VERSION_CODE, Intrinsics.q("", Integer.valueOf(i11)));
        }
        if (!aVar.b(this.language)) {
            headers.put(LANGUAGE, this.language);
        }
        if (!aVar.b(this.country)) {
            headers.put(COUNTRY, this.country);
        }
        return Headers.INSTANCE.of(headers);
    }

    private final HttpUrl getHttpUrl(String url, Map<String, String> params) {
        HttpUrl parse = HttpUrl.INSTANCE.parse(url);
        HttpUrl.Builder newBuilder = parse == null ? null : parse.newBuilder();
        if (gg.a.f63688a.c(params) && params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (newBuilder != null) {
                    newBuilder.addQueryParameter(key, value);
                }
            }
        }
        if (newBuilder == null) {
            return null;
        }
        return newBuilder.build();
    }

    private final RequestBody getJSONBody(Object json) {
        String json2 = new Gson().toJson(json);
        Intrinsics.g(json2, "Gson().toJson(json)");
        return getRawBody(json2, MediaType.INSTANCE.parse(ContentType.JSON.getValue()));
    }

    private final MultipartBody getMultipartBody(Map<String, String> params) {
        MultipartBody.Builder builder = new MultipartBody.Builder(null, 1, null);
        if (gg.a.f63688a.c(params)) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                builder.addFormDataPart(entry.getKey(), entry.getValue());
            }
        }
        return builder.build();
    }

    private final RequestBody getRawBody(String content, MediaType r32) {
        return RequestBody.INSTANCE.create(r32, content);
    }

    public static /* synthetic */ void init$default(HttpRequestor httpRequestor, Context context, String str, WorkMode workMode, ProgressListener progressListener, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: init");
        }
        if ((i11 & 4) != 0) {
            workMode = WorkMode.MODE_ONLINE;
        }
        if ((i11 & 8) != 0) {
            progressListener = null;
        }
        httpRequestor.init(context, str, workMode, progressListener);
    }

    public static /* synthetic */ void init$default(HttpRequestor httpRequestor, Context context, String str, WorkMode workMode, ProgressListener progressListener, boolean z10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: init");
        }
        if ((i11 & 4) != 0) {
            workMode = WorkMode.MODE_ONLINE;
        }
        WorkMode workMode2 = workMode;
        if ((i11 & 8) != 0) {
            progressListener = null;
        }
        ProgressListener progressListener2 = progressListener;
        if ((i11 & 16) != 0) {
            z10 = false;
        }
        httpRequestor.init(context, str, workMode2, progressListener2, z10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:?, code lost:
    
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final okhttp3.Call post(java.lang.String r4, java.util.Map<java.lang.String, java.lang.String> r5, java.util.Map<java.lang.String, java.lang.String> r6, okhttp3.RequestBody r7, com.tmc.network.INetworkCallback r8) {
        /*
            r3 = this;
            com.tmc.network.NetworkCallback r0 = new com.tmc.network.NetworkCallback
            r0.<init>(r8)
            r1 = 0
            okhttp3.Request$Builder r2 = new okhttp3.Request$Builder     // Catch: java.lang.Exception -> L5c
            r2.<init>()     // Catch: java.lang.Exception -> L5c
            okhttp3.HttpUrl r4 = r3.getHttpUrl(r4, r6)     // Catch: java.lang.Exception -> L5c
            kotlin.jvm.internal.Intrinsics.e(r4)     // Catch: java.lang.Exception -> L5c
            okhttp3.Request$Builder r4 = r2.url(r4)     // Catch: java.lang.Exception -> L5c
            okhttp3.Headers r6 = r3.getHeaders(r5)     // Catch: java.lang.Exception -> L5c
            okhttp3.Request$Builder r4 = r4.headers(r6)     // Catch: java.lang.Exception -> L5c
            okhttp3.Request$Builder r4 = r4.post(r7)     // Catch: java.lang.Exception -> L5c
            com.tmc.network.HttpClient r6 = r3.httpClient     // Catch: java.lang.Exception -> L5c
            okhttp3.Request r4 = r4.build()     // Catch: java.lang.Exception -> L5c
            okhttp3.Call r4 = r6.newCall(r4)     // Catch: java.lang.Exception -> L5c
            if (r5 != 0) goto L2f
            goto L38
        L2f:
            java.lang.String r6 = "m-timeout"
            java.lang.Object r5 = r5.get(r6)     // Catch: java.lang.Exception -> L59
            r1 = r5
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Exception -> L59
        L38:
            java.lang.Long r5 = r3.getCallTimeout(r1)     // Catch: java.lang.Exception -> L59
            if (r5 != 0) goto L3f
            goto L52
        L3f:
            if (r4 != 0) goto L42
            goto L52
        L42:
            okio.Timeout r6 = r4.timeout()     // Catch: java.lang.Exception -> L59
            if (r6 != 0) goto L49
            goto L52
        L49:
            long r1 = r5.longValue()     // Catch: java.lang.Exception -> L59
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Exception -> L59
            r6.timeout(r1, r5)     // Catch: java.lang.Exception -> L59
        L52:
            if (r4 != 0) goto L55
            goto L66
        L55:
            com.google.firebase.perf.network.FirebasePerfOkHttpClient.enqueue(r4, r0)     // Catch: java.lang.Exception -> L59
            goto L66
        L59:
            r5 = move-exception
            r1 = r4
            goto L5d
        L5c:
            r5 = move-exception
        L5d:
            gg.b r4 = gg.b.f63690a
            r4.e(r5)
            r8.onFailure(r1, r5)
            r4 = r1
        L66:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tmc.network.HttpRequestor.post(java.lang.String, java.util.Map, java.util.Map, okhttp3.RequestBody, com.tmc.network.INetworkCallback):okhttp3.Call");
    }

    private final void post(String url, Map<String, String> headers, Map<String, String> params, RequestBody requestBody, Callback callback) {
        try {
            Request.Builder builder = new Request.Builder();
            HttpUrl httpUrl = getHttpUrl(url, params);
            Intrinsics.e(httpUrl);
            Call newCall = this.httpClient.newCall(builder.url(httpUrl).headers(getHeaders(headers)).post(requestBody).build());
            if (newCall == null) {
                return;
            }
            FirebasePerfOkHttpClient.enqueue(newCall, callback);
        } catch (Exception e11) {
            gg.b.f63690a.e(e11);
        }
    }

    public final Call delete(String url, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, INetworkCallback callback) {
        Intrinsics.h(url, "url");
        Intrinsics.h(callback, "callback");
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, String> map4 = map;
        String str = CONTENT_TYPE;
        if (map4.get(str) == null) {
            map4.put(str, ContentType.FORM.getValue());
        }
        Intrinsics.e(map3);
        return delete(url, map4, map2, getFormBody(map3), callback);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:?, code lost:
    
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final okhttp3.Call delete(java.lang.String r4, java.util.Map<java.lang.String, java.lang.String> r5, java.util.Map<java.lang.String, java.lang.String> r6, okhttp3.RequestBody r7, com.tmc.network.INetworkCallback r8) {
        /*
            r3 = this;
            java.lang.String r0 = "url"
            kotlin.jvm.internal.Intrinsics.h(r4, r0)
            java.lang.String r0 = "requestBody"
            kotlin.jvm.internal.Intrinsics.h(r7, r0)
            java.lang.String r0 = "callback"
            kotlin.jvm.internal.Intrinsics.h(r8, r0)
            com.tmc.network.NetworkCallback r0 = new com.tmc.network.NetworkCallback
            r0.<init>(r8)
            r1 = 0
            okhttp3.Request$Builder r2 = new okhttp3.Request$Builder     // Catch: java.lang.Exception -> L6b
            r2.<init>()     // Catch: java.lang.Exception -> L6b
            okhttp3.HttpUrl r4 = r3.getHttpUrl(r4, r6)     // Catch: java.lang.Exception -> L6b
            kotlin.jvm.internal.Intrinsics.e(r4)     // Catch: java.lang.Exception -> L6b
            okhttp3.Request$Builder r4 = r2.url(r4)     // Catch: java.lang.Exception -> L6b
            okhttp3.Headers r6 = r3.getHeaders(r5)     // Catch: java.lang.Exception -> L6b
            okhttp3.Request$Builder r4 = r4.headers(r6)     // Catch: java.lang.Exception -> L6b
            okhttp3.Request$Builder r4 = r4.delete(r7)     // Catch: java.lang.Exception -> L6b
            com.tmc.network.HttpClient r6 = r3.httpClient     // Catch: java.lang.Exception -> L6b
            okhttp3.Request r4 = r4.build()     // Catch: java.lang.Exception -> L6b
            okhttp3.Call r4 = r6.newCall(r4)     // Catch: java.lang.Exception -> L6b
            if (r5 != 0) goto L3e
            goto L47
        L3e:
            java.lang.String r6 = "m-timeout"
            java.lang.Object r5 = r5.get(r6)     // Catch: java.lang.Exception -> L68
            r1 = r5
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Exception -> L68
        L47:
            java.lang.Long r5 = r3.getCallTimeout(r1)     // Catch: java.lang.Exception -> L68
            if (r5 != 0) goto L4e
            goto L61
        L4e:
            if (r4 != 0) goto L51
            goto L61
        L51:
            okio.Timeout r6 = r4.timeout()     // Catch: java.lang.Exception -> L68
            if (r6 != 0) goto L58
            goto L61
        L58:
            long r1 = r5.longValue()     // Catch: java.lang.Exception -> L68
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Exception -> L68
            r6.timeout(r1, r5)     // Catch: java.lang.Exception -> L68
        L61:
            if (r4 != 0) goto L64
            goto L75
        L64:
            com.google.firebase.perf.network.FirebasePerfOkHttpClient.enqueue(r4, r0)     // Catch: java.lang.Exception -> L68
            goto L75
        L68:
            r5 = move-exception
            r1 = r4
            goto L6c
        L6b:
            r5 = move-exception
        L6c:
            gg.b r4 = gg.b.f63690a
            r4.e(r5)
            r8.onFailure(r1, r5)
            r4 = r1
        L75:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tmc.network.HttpRequestor.delete(java.lang.String, java.util.Map, java.util.Map, okhttp3.RequestBody, com.tmc.network.INetworkCallback):okhttp3.Call");
    }

    public final void delete(String url, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Callback callback) {
        Intrinsics.h(url, "url");
        Intrinsics.h(callback, "callback");
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, String> map4 = map;
        String str = CONTENT_TYPE;
        if (map4.get(str) == null) {
            map4.put(str, ContentType.FORM.getValue());
        }
        Intrinsics.e(map3);
        delete(url, map4, map2, getFormBody(map3), callback);
    }

    public final void delete(String url, Map<String, String> map, Map<String, String> map2, RequestBody requestBody, Callback callback) {
        Intrinsics.h(url, "url");
        Intrinsics.h(requestBody, "requestBody");
        Intrinsics.h(callback, "callback");
        try {
            Request.Builder builder = new Request.Builder();
            HttpUrl httpUrl = getHttpUrl(url, map2);
            Intrinsics.e(httpUrl);
            Call newCall = this.httpClient.newCall(builder.url(httpUrl).headers(getHeaders(map)).delete(requestBody).build());
            if (newCall == null) {
                return;
            }
            FirebasePerfOkHttpClient.enqueue(newCall, callback);
        } catch (Exception e11) {
            gg.b.f63690a.e(e11);
        }
    }

    public final Call get(String url, Map<String, String> params, INetworkCallback callback) {
        Intrinsics.h(url, "url");
        Intrinsics.h(params, "params");
        Intrinsics.h(callback, "callback");
        return get(url, (Map<String, String>) null, params, callback);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:?, code lost:
    
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final okhttp3.Call get(java.lang.String r4, java.util.Map<java.lang.String, java.lang.String> r5, java.util.Map<java.lang.String, java.lang.String> r6, com.tmc.network.INetworkCallback r7) {
        /*
            r3 = this;
            java.lang.String r0 = "url"
            kotlin.jvm.internal.Intrinsics.h(r4, r0)
            java.lang.String r0 = "callback"
            kotlin.jvm.internal.Intrinsics.h(r7, r0)
            com.tmc.network.NetworkCallback r0 = new com.tmc.network.NetworkCallback
            r0.<init>(r7)
            r1 = 0
            okhttp3.Request$Builder r2 = new okhttp3.Request$Builder     // Catch: java.lang.Exception -> L66
            r2.<init>()     // Catch: java.lang.Exception -> L66
            okhttp3.HttpUrl r4 = r3.getHttpUrl(r4, r6)     // Catch: java.lang.Exception -> L66
            kotlin.jvm.internal.Intrinsics.e(r4)     // Catch: java.lang.Exception -> L66
            okhttp3.Request$Builder r4 = r2.url(r4)     // Catch: java.lang.Exception -> L66
            okhttp3.Headers r6 = r3.getHeaders(r5)     // Catch: java.lang.Exception -> L66
            okhttp3.Request$Builder r4 = r4.headers(r6)     // Catch: java.lang.Exception -> L66
            okhttp3.Request$Builder r4 = r4.get()     // Catch: java.lang.Exception -> L66
            com.tmc.network.HttpClient r6 = r3.httpClient     // Catch: java.lang.Exception -> L66
            okhttp3.Request r4 = r4.build()     // Catch: java.lang.Exception -> L66
            okhttp3.Call r4 = r6.newCall(r4)     // Catch: java.lang.Exception -> L66
            if (r5 != 0) goto L39
            goto L42
        L39:
            java.lang.String r6 = "m-timeout"
            java.lang.Object r5 = r5.get(r6)     // Catch: java.lang.Exception -> L63
            r1 = r5
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Exception -> L63
        L42:
            java.lang.Long r5 = r3.getCallTimeout(r1)     // Catch: java.lang.Exception -> L63
            if (r5 != 0) goto L49
            goto L5c
        L49:
            if (r4 != 0) goto L4c
            goto L5c
        L4c:
            okio.Timeout r6 = r4.timeout()     // Catch: java.lang.Exception -> L63
            if (r6 != 0) goto L53
            goto L5c
        L53:
            long r1 = r5.longValue()     // Catch: java.lang.Exception -> L63
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Exception -> L63
            r6.timeout(r1, r5)     // Catch: java.lang.Exception -> L63
        L5c:
            if (r4 != 0) goto L5f
            goto L70
        L5f:
            com.google.firebase.perf.network.FirebasePerfOkHttpClient.enqueue(r4, r0)     // Catch: java.lang.Exception -> L63
            goto L70
        L63:
            r5 = move-exception
            r1 = r4
            goto L67
        L66:
            r5 = move-exception
        L67:
            r7.onFailure(r1, r5)
            gg.b r4 = gg.b.f63690a
            r4.e(r5)
            r4 = r1
        L70:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tmc.network.HttpRequestor.get(java.lang.String, java.util.Map, java.util.Map, com.tmc.network.INetworkCallback):okhttp3.Call");
    }

    public final void get(String url, Map<String, String> headers, Map<String, String> params, Callback callback) {
        Intrinsics.h(url, "url");
        Intrinsics.h(callback, "callback");
        try {
            Request.Builder builder = new Request.Builder();
            HttpUrl httpUrl = getHttpUrl(url, params);
            Intrinsics.e(httpUrl);
            Call newCall = this.httpClient.newCall(builder.url(httpUrl).headers(getHeaders(headers)).get().build());
            if (newCall == null) {
                return;
            }
            FirebasePerfOkHttpClient.enqueue(newCall, callback);
        } catch (Exception e11) {
            gg.b.f63690a.e(e11);
        }
    }

    public final void get(String url, Map<String, String> params, Callback callback) {
        Intrinsics.h(url, "url");
        Intrinsics.h(params, "params");
        Intrinsics.h(callback, "callback");
        get(url, (Map<String, String>) null, params, callback);
    }

    public final Long getCallTimeout(String r62) {
        if (r62 == null) {
            return null;
        }
        try {
            long parseLong = Long.parseLong(r62);
            if (parseLong <= 0) {
                return null;
            }
            return parseLong >= MAX_CALL_TIMEOUT ? Long.valueOf(MAX_CALL_TIMEOUT) : Long.valueOf(parseLong);
        } catch (Throwable th2) {
            gg.b.f63690a.e(th2);
            return null;
        }
    }

    public final HttpClient getHttpClient() {
        return this.httpClient;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:?, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final okhttp3.Call head(java.lang.String r5, java.util.Map<java.lang.String, java.lang.String> r6, java.util.Map<java.lang.String, java.lang.String> r7, com.tmc.network.INetworkCallback r8) {
        /*
            r4 = this;
            java.lang.String r0 = "url"
            kotlin.jvm.internal.Intrinsics.h(r5, r0)
            java.lang.String r0 = "callback"
            kotlin.jvm.internal.Intrinsics.h(r8, r0)
            r0 = 0
            com.tmc.network.NetworkCallback r1 = new com.tmc.network.NetworkCallback     // Catch: java.lang.Exception -> L66
            r1.<init>(r8)     // Catch: java.lang.Exception -> L66
            okhttp3.Request$Builder r2 = new okhttp3.Request$Builder     // Catch: java.lang.Exception -> L66
            r2.<init>()     // Catch: java.lang.Exception -> L66
            okhttp3.HttpUrl r5 = r4.getHttpUrl(r5, r7)     // Catch: java.lang.Exception -> L66
            kotlin.jvm.internal.Intrinsics.e(r5)     // Catch: java.lang.Exception -> L66
            okhttp3.Request$Builder r5 = r2.url(r5)     // Catch: java.lang.Exception -> L66
            okhttp3.Headers r7 = r4.getHeaders(r6)     // Catch: java.lang.Exception -> L66
            okhttp3.Request$Builder r5 = r5.headers(r7)     // Catch: java.lang.Exception -> L66
            okhttp3.Request$Builder r5 = r5.head()     // Catch: java.lang.Exception -> L66
            com.tmc.network.HttpClient r7 = r4.httpClient     // Catch: java.lang.Exception -> L66
            okhttp3.Request r5 = r5.build()     // Catch: java.lang.Exception -> L66
            okhttp3.Call r5 = r7.newCall(r5)     // Catch: java.lang.Exception -> L66
            if (r6 != 0) goto L39
            goto L42
        L39:
            java.lang.String r7 = "m-timeout"
            java.lang.Object r6 = r6.get(r7)     // Catch: java.lang.Exception -> L63
            r0 = r6
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> L63
        L42:
            java.lang.Long r6 = r4.getCallTimeout(r0)     // Catch: java.lang.Exception -> L63
            if (r6 != 0) goto L49
            goto L5c
        L49:
            if (r5 != 0) goto L4c
            goto L5c
        L4c:
            okio.Timeout r7 = r5.timeout()     // Catch: java.lang.Exception -> L63
            if (r7 != 0) goto L53
            goto L5c
        L53:
            long r2 = r6.longValue()     // Catch: java.lang.Exception -> L63
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Exception -> L63
            r7.timeout(r2, r6)     // Catch: java.lang.Exception -> L63
        L5c:
            if (r5 != 0) goto L5f
            goto L70
        L5f:
            com.google.firebase.perf.network.FirebasePerfOkHttpClient.enqueue(r5, r1)     // Catch: java.lang.Exception -> L63
            goto L70
        L63:
            r6 = move-exception
            r0 = r5
            goto L67
        L66:
            r6 = move-exception
        L67:
            r8.onFailure(r0, r6)
            gg.b r5 = gg.b.f63690a
            r5.e(r6)
            r5 = r0
        L70:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tmc.network.HttpRequestor.head(java.lang.String, java.util.Map, java.util.Map, com.tmc.network.INetworkCallback):okhttp3.Call");
    }

    public final void init(Context context, String appId, WorkMode workMode, ProgressListener progressListener) {
        try {
            if (this.isInit.get()) {
                return;
            }
            gg.b bVar = gg.b.f63690a;
            bVar.d("HttpRequestor", "HttpRequestor will init");
            synchronized (this) {
                bVar.d("HttpRequestor", "HttpRequestor start init.");
                if (this.isInit.get()) {
                    return;
                }
                NetworkConfig.INSTANCE.setNetworkMonitorEnable(false);
                GateWaySdk.init(context, appId, workMode);
                HttpClient.INSTANCE.setProgressListener(progressListener);
                NetworkMonitor.INSTANCE.init(context);
                d.f40872b.a().a(context);
                NetworkAdapter.INSTANCE.init();
                this.isInit.set(true);
                Unit unit = Unit.f67184a;
            }
        } catch (Exception e11) {
            gg.b.f63690a.e(e11);
        }
    }

    public final void init(Context context, String appId, WorkMode workMode, ProgressListener progressListener, boolean isNetworkMonitorEnable) {
        try {
            if (this.isInit.get()) {
                return;
            }
            gg.b bVar = gg.b.f63690a;
            bVar.d("HttpRequestor", "HttpRequestor will init");
            synchronized (this) {
                bVar.d("HttpRequestor", Intrinsics.q("HttpRequestor start init. isNetworkMonitorEnable =", Boolean.valueOf(isNetworkMonitorEnable)));
                if (this.isInit.get()) {
                    return;
                }
                NetworkConfig.INSTANCE.setNetworkMonitorEnable(isNetworkMonitorEnable);
                GateWaySdk.init(context, appId, workMode);
                bVar.d("HttpRequestor", "HttpRequestor GateWaySdk init finish");
                HttpClient.INSTANCE.setProgressListener(progressListener);
                NetworkMonitor.INSTANCE.init(context);
                d.f40872b.a().a(context);
                NetworkAdapter.INSTANCE.init();
                this.isInit.set(true);
                Unit unit = Unit.f67184a;
            }
        } catch (Exception e11) {
            gg.b.f63690a.e(e11);
        }
    }

    public final Call post(String url, Map<String, String> headers, Map<String, String> params, Map<String, String> formData, INetworkCallback callback) {
        Intrinsics.h(url, "url");
        Intrinsics.h(callback, "callback");
        if (headers == null) {
            headers = new HashMap<>();
        }
        Map<String, String> map = headers;
        String str = CONTENT_TYPE;
        if (map.get(str) == null) {
            map.put(str, ContentType.FORM.getValue());
        }
        Intrinsics.e(formData);
        return post(url, map, params, getFormBody(formData), callback);
    }

    public final void post(String url, Map<String, String> headers, Map<String, String> params, Map<String, String> formData, Callback callback) {
        Intrinsics.h(url, "url");
        Intrinsics.h(callback, "callback");
        if (headers == null) {
            headers = new HashMap<>();
        }
        Map<String, String> map = headers;
        String str = CONTENT_TYPE;
        if (map.get(str) == null) {
            map.put(str, ContentType.FORM.getValue());
        }
        Intrinsics.e(formData);
        post(url, map, params, getFormBody(formData), callback);
    }

    @Deprecated
    public final Call postJSON(String url, Map<String, String> headers, Map<String, String> params, Object json, INetworkCallback callback) {
        Intrinsics.h(url, "url");
        Intrinsics.h(callback, "callback");
        if (headers == null) {
            headers = new HashMap<>();
        }
        Map<String, String> map = headers;
        String str = CONTENT_TYPE;
        if (map.get(str) == null) {
            map.put(str, ContentType.JSON.getValue());
        }
        RequestBody jSONBody = getJSONBody(json);
        Intrinsics.e(jSONBody);
        return post(url, map, params, jSONBody, callback);
    }

    @Deprecated
    public final void postJSON(String url, Map<String, String> headers, Map<String, String> params, Object json, Callback callback) {
        Intrinsics.h(url, "url");
        Intrinsics.h(callback, "callback");
        if (headers == null) {
            headers = new HashMap<>();
        }
        Map<String, String> map = headers;
        String str = CONTENT_TYPE;
        if (map.get(str) == null) {
            map.put(str, ContentType.JSON.getValue());
        }
        RequestBody jSONBody = getJSONBody(json);
        Intrinsics.e(jSONBody);
        post(url, map, params, jSONBody, callback);
    }

    @Deprecated
    public final Call postMultipart(String url, Map<String, String> headers, Map<String, String> params, Map<String, String> multipartData, INetworkCallback callback) {
        Intrinsics.h(url, "url");
        Intrinsics.h(callback, "callback");
        if (headers == null) {
            headers = new HashMap<>();
        }
        Map<String, String> map = headers;
        String str = CONTENT_TYPE;
        if (map.get(str) == null) {
            map.put(str, ContentType.MULTIPART.getValue());
        }
        Intrinsics.e(multipartData);
        return post(url, map, params, getMultipartBody(multipartData), callback);
    }

    @Deprecated
    public final void postMultipart(String url, Map<String, String> headers, Map<String, String> params, Map<String, String> multipartData, Callback callback) {
        Intrinsics.h(url, "url");
        Intrinsics.h(callback, "callback");
        if (headers == null) {
            headers = new HashMap<>();
        }
        Map<String, String> map = headers;
        String str = CONTENT_TYPE;
        if (map.get(str) == null) {
            map.put(str, ContentType.MULTIPART.getValue());
        }
        Intrinsics.e(multipartData);
        post(url, map, params, getMultipartBody(multipartData), callback);
    }

    @Deprecated
    public final Call postRequestBody(String url, Map<String, String> headers, Map<String, String> params, RequestBody requestBody, INetworkCallback callback) {
        Intrinsics.h(url, "url");
        Intrinsics.h(requestBody, "requestBody");
        Intrinsics.h(callback, "callback");
        if (headers == null) {
            headers = new HashMap<>();
        }
        Map<String, String> map = headers;
        String str = CONTENT_TYPE;
        if (map.get(str) == null) {
            map.put(str, ContentType.MULTIPART.getValue());
        }
        return post(url, map, params, requestBody, callback);
    }

    @Deprecated
    public final void postRequestBody(String url, Map<String, String> headers, Map<String, String> params, RequestBody requestBody, Callback callback) {
        Intrinsics.h(url, "url");
        Intrinsics.h(requestBody, "requestBody");
        Intrinsics.h(callback, "callback");
        if (headers == null) {
            headers = new HashMap<>();
        }
        Map<String, String> map = headers;
        String str = CONTENT_TYPE;
        if (map.get(str) == null) {
            map.put(str, ContentType.MULTIPART.getValue());
        }
        post(url, map, params, requestBody, callback);
    }

    public final Call postV2(String url, Map<String, String> headers, Map<String, String> params, Map<String, String> formData, INetworkCallback callback) {
        Intrinsics.h(url, "url");
        Intrinsics.h(callback, "callback");
        if (headers == null) {
            headers = new HashMap<>();
        }
        Map<String, String> map = headers;
        String str = CONTENT_TYPE;
        if (map.get(str) == null) {
            map.put(str, ContentType.FORM.getValue());
        }
        if (enablePostMode) {
            Intrinsics.e(formData);
            return post(url, map, params, buildRequestBody(map, formData), callback);
        }
        Intrinsics.e(formData);
        return post(url, map, params, getFormBody(formData), callback);
    }

    public final Call put(String url, Map<String, String> headers, Map<String, String> params, Map<String, String> formData, INetworkCallback callback) {
        Intrinsics.h(url, "url");
        Intrinsics.h(callback, "callback");
        if (headers == null) {
            headers = new HashMap<>();
        }
        Map<String, String> map = headers;
        String str = CONTENT_TYPE;
        if (map.get(str) == null) {
            map.put(str, ContentType.FORM.getValue());
        }
        Intrinsics.e(formData);
        return put(url, map, params, getFormBody(formData), callback);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:?, code lost:
    
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final okhttp3.Call put(java.lang.String r4, java.util.Map<java.lang.String, java.lang.String> r5, java.util.Map<java.lang.String, java.lang.String> r6, okhttp3.RequestBody r7, com.tmc.network.INetworkCallback r8) {
        /*
            r3 = this;
            java.lang.String r0 = "url"
            kotlin.jvm.internal.Intrinsics.h(r4, r0)
            java.lang.String r0 = "requestBody"
            kotlin.jvm.internal.Intrinsics.h(r7, r0)
            java.lang.String r0 = "callback"
            kotlin.jvm.internal.Intrinsics.h(r8, r0)
            com.tmc.network.NetworkCallback r0 = new com.tmc.network.NetworkCallback
            r0.<init>(r8)
            r1 = 0
            okhttp3.Request$Builder r2 = new okhttp3.Request$Builder     // Catch: java.lang.Exception -> L6b
            r2.<init>()     // Catch: java.lang.Exception -> L6b
            okhttp3.HttpUrl r4 = r3.getHttpUrl(r4, r6)     // Catch: java.lang.Exception -> L6b
            kotlin.jvm.internal.Intrinsics.e(r4)     // Catch: java.lang.Exception -> L6b
            okhttp3.Request$Builder r4 = r2.url(r4)     // Catch: java.lang.Exception -> L6b
            okhttp3.Headers r6 = r3.getHeaders(r5)     // Catch: java.lang.Exception -> L6b
            okhttp3.Request$Builder r4 = r4.headers(r6)     // Catch: java.lang.Exception -> L6b
            okhttp3.Request$Builder r4 = r4.put(r7)     // Catch: java.lang.Exception -> L6b
            com.tmc.network.HttpClient r6 = r3.httpClient     // Catch: java.lang.Exception -> L6b
            okhttp3.Request r4 = r4.build()     // Catch: java.lang.Exception -> L6b
            okhttp3.Call r4 = r6.newCall(r4)     // Catch: java.lang.Exception -> L6b
            if (r5 != 0) goto L3e
            goto L47
        L3e:
            java.lang.String r6 = "m-timeout"
            java.lang.Object r5 = r5.get(r6)     // Catch: java.lang.Exception -> L68
            r1 = r5
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Exception -> L68
        L47:
            java.lang.Long r5 = r3.getCallTimeout(r1)     // Catch: java.lang.Exception -> L68
            if (r5 != 0) goto L4e
            goto L61
        L4e:
            if (r4 != 0) goto L51
            goto L61
        L51:
            okio.Timeout r6 = r4.timeout()     // Catch: java.lang.Exception -> L68
            if (r6 != 0) goto L58
            goto L61
        L58:
            long r1 = r5.longValue()     // Catch: java.lang.Exception -> L68
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Exception -> L68
            r6.timeout(r1, r5)     // Catch: java.lang.Exception -> L68
        L61:
            if (r4 != 0) goto L64
            goto L75
        L64:
            com.google.firebase.perf.network.FirebasePerfOkHttpClient.enqueue(r4, r0)     // Catch: java.lang.Exception -> L68
            goto L75
        L68:
            r5 = move-exception
            r1 = r4
            goto L6c
        L6b:
            r5 = move-exception
        L6c:
            gg.b r4 = gg.b.f63690a
            r4.e(r5)
            r8.onFailure(r1, r5)
            r4 = r1
        L75:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tmc.network.HttpRequestor.put(java.lang.String, java.util.Map, java.util.Map, okhttp3.RequestBody, com.tmc.network.INetworkCallback):okhttp3.Call");
    }

    public final void put(String url, Map<String, String> headers, Map<String, String> params, Map<String, String> formData, Callback callback) {
        Intrinsics.h(url, "url");
        Intrinsics.h(callback, "callback");
        if (headers == null) {
            headers = new HashMap<>();
        }
        Map<String, String> map = headers;
        String str = CONTENT_TYPE;
        if (map.get(str) == null) {
            map.put(str, ContentType.FORM.getValue());
        }
        Intrinsics.e(formData);
        put(url, map, params, getFormBody(formData), callback);
    }

    public final void put(String url, Map<String, String> headers, Map<String, String> params, RequestBody requestBody, Callback callback) {
        Intrinsics.h(url, "url");
        Intrinsics.h(requestBody, "requestBody");
        Intrinsics.h(callback, "callback");
        try {
            Request.Builder builder = new Request.Builder();
            HttpUrl httpUrl = getHttpUrl(url, params);
            Intrinsics.e(httpUrl);
            Call newCall = this.httpClient.newCall(builder.url(httpUrl).headers(getHeaders(headers)).put(requestBody).build());
            if (newCall == null) {
                return;
            }
            FirebasePerfOkHttpClient.enqueue(newCall, callback);
        } catch (Exception e11) {
            gg.b.f63690a.e(e11);
        }
    }

    public final void setAppInfo(String r22, String r32, int versionCode) {
        Intrinsics.h(r22, "appName");
        Intrinsics.h(r32, "appVersion");
        this.appName = r22;
        this.appVersion = r32;
        this.versionCode = versionCode;
    }

    public final void setCountry(String r22) {
        Intrinsics.h(r22, "country");
        this.country = r22;
    }

    public final void setGateWayActivateSignConfig(List<String> hostList, List<String> pathList) {
        Intrinsics.h(hostList, "hostList");
        Intrinsics.h(pathList, "pathList");
        GateWaySdk.setActivateSignConfig(hostList, pathList);
    }

    public final void setGatewayAlwaysAccess(boolean ifGatewayAlwaysAccess) {
        this.ifGatewayAlwaysAccess = ifGatewayAlwaysAccess;
    }

    public final void setIfCommonHeader(boolean commonHeader) {
        this.ifCommonHeader = commonHeader;
    }

    public final void setLanguage(String r22) {
        Intrinsics.h(r22, "language");
        this.language = r22;
    }
}
