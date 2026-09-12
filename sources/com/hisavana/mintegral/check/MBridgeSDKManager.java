package com.hisavana.mintegral.check;

import android.content.Context;
import android.text.TextUtils;
import com.hisavana.common.bean.AppStartInfo;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.MBridgeSDK;
import com.mbridge.msdk.out.MBridgeSDKFactory;
import com.mbridge.msdk.out.SDKInitStatusListener;
import com.mbridge.msdk.system.MBridgeSDKImpl;
import java.util.Map;

/* loaded from: classes4.dex */
public final class MBridgeSDKManager {

    /* renamed from: e, reason: collision with root package name */
    private static MBridgeSDKInitializeState f33360e;

    /* renamed from: a, reason: collision with root package name */
    private volatile String f33361a;

    /* renamed from: b, reason: collision with root package name */
    private volatile String f33362b;

    /* renamed from: c, reason: collision with root package name */
    private volatile MBridgeSDKInitializeListener f33363c;

    /* renamed from: d, reason: collision with root package name */
    private MBridgeSDK f33364d;

    /* loaded from: classes4.dex */
    private static final class ClassHolder {

        /* renamed from: a, reason: collision with root package name */
        private static final MBridgeSDKManager f33365a = new MBridgeSDKManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class DefaultSDKInitStatusListener implements SDKInitStatusListener {

        /* renamed from: a, reason: collision with root package name */
        private String f33366a;

        /* renamed from: b, reason: collision with root package name */
        private String f33367b;

        /* renamed from: c, reason: collision with root package name */
        private MBridgeSDKInitializeListener f33368c;

        public DefaultSDKInitStatusListener(String str, String str2, MBridgeSDKInitializeListener mBridgeSDKInitializeListener) {
            this.f33366a = str;
            this.f33367b = str2;
            this.f33368c = mBridgeSDKInitializeListener;
        }

        @Override // com.mbridge.msdk.out.SDKInitStatusListener
        public void onInitFail(String str) {
            MBridgeSDKInitializeState unused = MBridgeSDKManager.f33360e = MBridgeSDKInitializeState.SDK_STATE_INITIALIZE_FAILURE;
            MBridgeSDKInitializeListener mBridgeSDKInitializeListener = this.f33368c;
            if (mBridgeSDKInitializeListener != null) {
                mBridgeSDKInitializeListener.onInitializeFailure("sdk initialize failed： an exception occurs");
            }
        }

        @Override // com.mbridge.msdk.out.SDKInitStatusListener
        public void onInitSuccess() {
            MBridgeSDKInitializeState unused = MBridgeSDKManager.f33360e = MBridgeSDKInitializeState.SDK_STATE_INITIALIZE_SUCCESS;
            MBridgeSDKInitializeListener mBridgeSDKInitializeListener = this.f33368c;
            if (mBridgeSDKInitializeListener != null) {
                mBridgeSDKInitializeListener.onInitializeSuccess(this.f33366a, this.f33367b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface MBridgeSDKInitializeListener {
        void onInitializeFailure(String str);

        void onInitializeSuccess(String str, String str2);
    }

    /* loaded from: classes4.dex */
    public enum MBridgeSDKInitializeState {
        SDK_STATE_UN_INITIALIZE,
        SDK_STATE_INITIALIZING,
        SDK_STATE_INITIALIZE_SUCCESS,
        SDK_STATE_INITIALIZE_FAILURE
    }

    private MBridgeSDKManager() {
        f33360e = MBridgeSDKInitializeState.SDK_STATE_UN_INITIALIZE;
    }

    private void b(Context context, boolean z10, Map map, MBridgeSDKInitializeListener mBridgeSDKInitializeListener) {
        try {
            MBridgeConstans.DEBUG = z10;
            MBridgeSDKImpl mBridgeSDK = MBridgeSDKFactory.getMBridgeSDK();
            this.f33364d = mBridgeSDK;
            Map<String, String> mBConfigurationMap = mBridgeSDK.getMBConfigurationMap(this.f33362b, this.f33361a, "");
            if (map != null && !map.isEmpty()) {
                mBConfigurationMap.putAll(map);
            }
            this.f33364d.setConsentStatus(context, AppStartInfo.userConsent ? 1 : 0);
            this.f33364d.init(mBConfigurationMap, context, new DefaultSDKInitStatusListener(this.f33361a, this.f33362b, this.f33363c));
            this.f33364d.setCoppaStatus(context, AppStartInfo.ageRestrictedUser);
        } catch (Exception e11) {
            f33360e = MBridgeSDKInitializeState.SDK_STATE_INITIALIZE_FAILURE;
            if (this.f33363c != null) {
                mBridgeSDKInitializeListener.onInitializeFailure(e11.getMessage());
            }
        }
    }

    private boolean c(Context context, String str, String str2) {
        boolean z10;
        String str3;
        boolean z11 = false;
        if (context == null) {
            str3 = "context must not null";
            z10 = false;
        } else {
            z10 = true;
            str3 = "";
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            z11 = z10;
        } else if (TextUtils.isEmpty(str3)) {
            str3 = "appKey or appID must not null";
        } else {
            str3 = str3 + " & appKey or appID must not null";
        }
        if (!z11 && !TextUtils.isEmpty(str3) && this.f33363c != null) {
            f33360e = MBridgeSDKInitializeState.SDK_STATE_INITIALIZE_FAILURE;
            this.f33363c.onInitializeFailure(str3);
        }
        return z11;
    }

    public static MBridgeSDKManager getInstance() {
        return ClassHolder.f33365a;
    }

    public String getAppID() {
        return this.f33362b;
    }

    public String getAppKey() {
        return this.f33361a;
    }

    public MBridgeSDKInitializeState getCurrentState() {
        return f33360e;
    }

    public MBridgeSDK getMBridgeSDK() {
        return this.f33364d;
    }

    public synchronized void initialize(Context context, String str, String str2) {
        initialize(context, str, str2, false, null, null);
    }

    public synchronized void initialize(Context context, String str, String str2, MBridgeSDKInitializeListener mBridgeSDKInitializeListener) {
        initialize(context, str, str2, false, null, mBridgeSDKInitializeListener);
    }

    public synchronized void initialize(Context context, String str, String str2, boolean z10) {
        initialize(context, str, str2, z10, null, null);
    }

    public synchronized void initialize(Context context, String str, String str2, boolean z10, MBridgeSDKInitializeListener mBridgeSDKInitializeListener) {
        initialize(context, str, str2, z10, null, mBridgeSDKInitializeListener);
    }

    public synchronized void initialize(Context context, String str, String str2, boolean z10, Map<String, String> map) {
        initialize(context, str, str2, z10, map, null);
    }

    public synchronized void initialize(Context context, String str, String str2, boolean z10, Map<String, String> map, MBridgeSDKInitializeListener mBridgeSDKInitializeListener) {
        MBridgeSDKInitializeState mBridgeSDKInitializeState = f33360e;
        MBridgeSDKInitializeState mBridgeSDKInitializeState2 = MBridgeSDKInitializeState.SDK_STATE_INITIALIZING;
        if (mBridgeSDKInitializeState == mBridgeSDKInitializeState2) {
            if (mBridgeSDKInitializeListener != null) {
                mBridgeSDKInitializeListener.onInitializeFailure("sdk is initializing");
            }
            return;
        }
        this.f33363c = mBridgeSDKInitializeListener;
        if (c(context, str, str2)) {
            if (f33360e == MBridgeSDKInitializeState.SDK_STATE_INITIALIZE_SUCCESS && TextUtils.equals(this.f33362b, str2) && TextUtils.equals(this.f33361a, str)) {
                if (this.f33363c != null) {
                    this.f33363c.onInitializeSuccess(this.f33361a, this.f33362b);
                }
            } else {
                f33360e = mBridgeSDKInitializeState2;
                this.f33361a = str;
                this.f33362b = str2;
                b(context, z10, map, this.f33363c);
            }
        }
    }
}
