package com.transsion.athena.enatha;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.transsion.athena.config.data.model.ehanat;
import com.transsion.athena.data.AppIdData;
import com.transsion.athena.data.TrackData;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class aethna extends athena implements Handler.Callback {

    /* renamed from: c, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile aethna f42770c;

    /* renamed from: d, reason: collision with root package name */
    private int f42771d;

    /* renamed from: e, reason: collision with root package name */
    private int f42772e;

    /* renamed from: f, reason: collision with root package name */
    private long f42773f;

    private aethna(Context context) {
        super(context);
        this.f42771d = 0;
        this.f42773f = 0L;
        HandlerThread handlerThread = new HandlerThread("Athena-LiteWorker", 10);
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper(), this);
        this.f42776b = handler;
        handler.sendEmptyMessage(303);
    }

    public static aethna a(Context context) {
        if (f42770c == null) {
            synchronized (aethna.class) {
                try {
                    if (f42770c == null) {
                        f42770c = new aethna(context);
                    }
                } finally {
                }
            }
        }
        return f42770c;
    }

    private void a(int i11, String str) {
        if (this.f42771d != 1) {
            com.transsion.athena.taaneh.aethna.a("Failed to connect to DCS service");
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("appId", Integer.valueOf(i11));
        if (TextUtils.isEmpty(str)) {
            contentValues.put("baseInfo", AppIdData.a(this.f42775a, i11).f42697b);
        } else {
            contentValues.put("baseInfo", str);
        }
        this.f42775a.getContentResolver().insert(Uri.parse("content://com.transsion.dataservice.provider/bind"), contentValues);
    }

    private void a(com.transsion.athena.data.aethna aethnaVar) {
        if (this.f42771d != 1) {
            com.transsion.athena.taaneh.aethna.a("Failed to connect to DCS service");
            return;
        }
        Cursor query = this.f42775a.getContentResolver().query(Uri.parse("content://com.transsion.dataservice.provider/property"), null, "prop_key = ?", new String[]{aethnaVar.f42717a}, null);
        if (query != null) {
            if (query.moveToNext()) {
                query.getString(0);
                android.support.v4.media.session.c.a(aethnaVar.f42718b.get());
            }
            query.close();
        }
    }

    private void a(String str) {
        if (this.f42771d == 1) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("trackObject", str);
            this.f42775a.getContentResolver().insert(Uri.parse("content://com.transsion.dataservice.provider/track"), contentValues);
            return;
        }
        com.transsion.athena.taaneh.aethna.a("Failed to connect to DCS service");
        long j11 = this.f42773f + 1;
        this.f42773f = j11;
        long j12 = 20;
        if (j11 % j12 == 0 && j11 / j12 <= 5 && com.transsion.athena.taaneh.anehat.c(this.f42775a)) {
            f();
        }
    }

    private void a(JSONObject jSONObject, String str, Object obj) throws JSONException {
        try {
            jSONObject.getString(str);
        } catch (JSONException unused) {
            jSONObject.put(str, obj);
        }
    }

    private void f() {
        Cursor query = this.f42775a.getContentResolver().query(Uri.parse("content://com.transsion.dataservice.provider/authorize"), null, "pkg = ?", new String[]{com.transsion.athena.taaneh.athena.h(this.f42775a)}, null);
        if (query != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("DCS authorize ");
            sb2.append(query.getCount() == 1 ? OfflineConstantsKt.OFFLINE_CONFIG_ENABLE : "disable");
            com.transsion.athena.taaneh.aethna.a(sb2.toString());
            if (query.getCount() == 1) {
                this.f42771d = 1;
            } else {
                this.f42771d = 2;
            }
            query.close();
        }
    }

    @Override // com.transsion.athena.enatha.athena
    public void a(Message message, long j11) {
        Handler handler = this.f42776b;
        if (handler != null) {
            handler.sendMessageDelayed(message, j11);
        }
    }

    @Override // com.transsion.athena.enatha.athena
    public void a(Runnable runnable) {
        Handler handler = this.f42776b;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    @Override // com.transsion.athena.enatha.athena
    public void a(Runnable runnable, long j11) {
        Handler handler = this.f42776b;
        if (handler != null) {
            handler.postDelayed(runnable, j11);
        }
    }

    @Override // com.transsion.athena.enatha.athena
    public void a(String str, TrackData trackData, long j11) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, str);
            jSONObject.put("tid", j11);
            jSONObject.put(NativeComponentConstants.KEY_COMPONENT_TYPE, trackData.d());
            JSONObject a11 = trackData.a();
            String str2 = ehanat.f42661h;
            a(a11, "_apkg", com.transsion.athena.taaneh.athena.h(this.f42775a));
            a(a11, "_avn", com.transsion.athena.taaneh.athena.j(this.f42775a));
            a(a11, "_avc", Integer.valueOf(com.transsion.athena.taaneh.athena.i(this.f42775a)));
            a(a11, "_atutp", Short.valueOf(ehanat.c()));
            String b11 = ehanat.b();
            if (b11 == null) {
                b11 = "";
            }
            a(a11, "_atuid", b11);
            a(a11, "_achannel", ehanat.g());
            a(a11, "_ainstallchnl", TextUtils.isEmpty(com.transsion.athena.taaneh.athena.e(this.f42775a)) ? " " : com.transsion.athena.taaneh.athena.e(this.f42775a));
            jSONObject.put("_eparam", a11);
        } catch (JSONException e11) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
        }
        String jSONObject2 = jSONObject.toString();
        int i11 = this.f42772e;
        if (i11 < 5000) {
            this.f42772e = i11 + 1;
            Message obtainMessage = this.f42776b.obtainMessage(Sdk$SDKError.Reason.INVALID_IFA_STATUS_VALUE);
            obtainMessage.obj = jSONObject2;
            this.f42776b.sendMessage(obtainMessage);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        try {
            int i11 = message.what;
            if (i11 == 302) {
                this.f42772e--;
                a((String) message.obj);
                return false;
            }
            if (i11 != 303) {
                if (i11 == 400) {
                    a(message.arg1, (String) message.obj);
                    return false;
                }
                if (i11 != 405) {
                    return false;
                }
                a((com.transsion.athena.data.aethna) message.obj);
                return false;
            }
            com.transsion.athena.taaneh.aethna.f42852a.m().r(ehanat.q());
            com.transsion.athena.taaneh.aethna.c("Athena SDK Version is 3.1.1.4");
            com.transsion.athena.taaneh.aethna.c("Athena is in Lite mode");
            if (com.transsion.athena.data.athena.b() == 0) {
                com.transsion.athena.taaneh.anehat.a("HostAppId must be set up in LiteMode");
            }
            f();
            return false;
        } catch (Exception e11) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
            return false;
        }
    }
}
