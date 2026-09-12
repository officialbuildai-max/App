package com.google.android.gms.gcm;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes3.dex */
public class Task implements ReflectedParcelable {
    public static final int EXTRAS_LIMIT_BYTES = 10240;
    public static final int NETWORK_STATE_ANY = 2;
    public static final int NETWORK_STATE_CONNECTED = 0;
    public static final int NETWORK_STATE_UNMETERED = 1;
    protected static final long UNINITIALIZED = -1;
    private final Bundle extras;
    private final String gcmTaskService;
    private final boolean isPersisted;
    private final int requiredNetworkState;
    private final boolean requiresCharging;
    private final String tag;
    private final boolean updateCurrent;
    private final Set<Uri> zzaw;
    private final boolean zzax;
    private final zzl zzay;

    /* loaded from: classes3.dex */
    public static abstract class Builder {
        protected Bundle extras;
        protected String gcmTaskService;
        protected boolean isPersisted;
        protected int requiredNetworkState;
        protected boolean requiresCharging;
        protected String tag;
        protected boolean updateCurrent;
        protected Set<Uri> zzaw = Collections.emptySet();

        @ShowFirstParty
        protected zzl zzay = zzl.zzaq;

        public abstract Task build();

        /* JADX INFO: Access modifiers changed from: protected */
        public void checkConditions() {
            Preconditions.checkArgument(this.gcmTaskService != null, "Must provide an endpoint for this task by calling setService(ComponentName).");
            GcmNetworkManager.zzd(this.tag);
            zzl zzlVar = this.zzay;
            if (zzlVar != null) {
                int zzi = zzlVar.zzi();
                if (zzi != 1 && zzi != 0) {
                    StringBuilder sb2 = new StringBuilder(45);
                    sb2.append("Must provide a valid RetryPolicy: ");
                    sb2.append(zzi);
                    throw new IllegalArgumentException(sb2.toString());
                }
                int zzj = zzlVar.zzj();
                int zzk = zzlVar.zzk();
                if (zzi == 0 && zzj < 0) {
                    StringBuilder sb3 = new StringBuilder(52);
                    sb3.append("InitialBackoffSeconds can't be negative: ");
                    sb3.append(zzj);
                    throw new IllegalArgumentException(sb3.toString());
                }
                if (zzi == 1 && zzj < 10) {
                    throw new IllegalArgumentException("RETRY_POLICY_LINEAR must have an initial backoff at least 10 seconds.");
                }
                if (zzk < zzj) {
                    int zzk2 = zzlVar.zzk();
                    StringBuilder sb4 = new StringBuilder(77);
                    sb4.append("MaximumBackoffSeconds must be greater than InitialBackoffSeconds: ");
                    sb4.append(zzk2);
                    throw new IllegalArgumentException(sb4.toString());
                }
            }
            if (this.isPersisted) {
                Task.zzg(this.extras);
            }
            if (!this.zzaw.isEmpty() && this.requiredNetworkState == 2) {
                throw new IllegalArgumentException("Required URIs may not be used with NETWORK_STATE_ANY");
            }
            Iterator<Uri> it = this.zzaw.iterator();
            while (it.hasNext()) {
                Task.zzd(it.next());
            }
        }

        public abstract Builder setExtras(Bundle bundle);

        public abstract Builder setPersisted(boolean z10);

        public abstract Builder setRequiredNetwork(int i11);

        public abstract Builder setRequiresCharging(boolean z10);

        public abstract Builder setService(Class<? extends GcmTaskService> cls);

        public abstract Builder setTag(String str);

        public abstract Builder setUpdateCurrent(boolean z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public Task(Parcel parcel) {
        Log.e("Task", "Constructing a Task object using a parcel.");
        this.gcmTaskService = parcel.readString();
        this.tag = parcel.readString();
        this.updateCurrent = parcel.readInt() == 1;
        this.isPersisted = parcel.readInt() == 1;
        this.requiredNetworkState = 2;
        this.zzaw = Collections.emptySet();
        this.requiresCharging = false;
        this.zzax = false;
        this.zzay = zzl.zzaq;
        this.extras = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task(Builder builder) {
        this.gcmTaskService = builder.gcmTaskService;
        this.tag = builder.tag;
        this.updateCurrent = builder.updateCurrent;
        this.isPersisted = builder.isPersisted;
        this.requiredNetworkState = builder.requiredNetworkState;
        this.zzaw = builder.zzaw;
        this.requiresCharging = builder.requiresCharging;
        this.zzax = false;
        this.extras = builder.extras;
        zzl zzlVar = builder.zzay;
        this.zzay = zzlVar == null ? zzl.zzaq : zzlVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzd(Uri uri) {
        if (uri == null) {
            throw new IllegalArgumentException("Null URI");
        }
        String scheme = uri.getScheme();
        String host = uri.getHost();
        if (TextUtils.isEmpty(host) || "null".equals(host)) {
            throw new IllegalArgumentException("URI hostname is required");
        }
        try {
            int port = uri.getPort();
            if (!"tcp".equals(scheme)) {
                if (!"ping".equals(scheme)) {
                    String valueOf = String.valueOf(scheme);
                    throw new IllegalArgumentException(valueOf.length() != 0 ? "Unsupported required URI scheme: ".concat(valueOf) : new String("Unsupported required URI scheme: "));
                }
                if (port != -1) {
                    throw new IllegalArgumentException("Ping does not support port numbers");
                }
                return;
            }
            if (port <= 0 || port > 65535) {
                int port2 = uri.getPort();
                StringBuilder sb2 = new StringBuilder(38);
                sb2.append("Invalid required URI port: ");
                sb2.append(port2);
                throw new IllegalArgumentException(sb2.toString());
            }
        } catch (NumberFormatException e11) {
            String valueOf2 = String.valueOf(e11.getMessage());
            throw new IllegalArgumentException(valueOf2.length() != 0 ? "Invalid port number: ".concat(valueOf2) : new String("Invalid port number: "));
        }
    }

    public static void zzg(Bundle bundle) {
        if (bundle != null) {
            Parcel obtain = Parcel.obtain();
            bundle.writeToParcel(obtain, 0);
            int dataSize = obtain.dataSize();
            obtain.recycle();
            if (dataSize > 10240) {
                StringBuilder sb2 = new StringBuilder(55);
                sb2.append("Extras exceeding maximum size(10240 bytes): ");
                sb2.append(dataSize);
                throw new IllegalArgumentException(sb2.toString());
            }
            Iterator<String> it = bundle.keySet().iterator();
            while (it.hasNext()) {
                Object obj = bundle.get(it.next());
                if (!(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Double) && !(obj instanceof String) && !(obj instanceof Boolean)) {
                    if (!(obj instanceof Bundle)) {
                        throw new IllegalArgumentException("Only the following extra parameter types are supported: Integer, Long, Double, String, Boolean, and nested Bundles with the same restrictions.");
                    }
                    zzg((Bundle) obj);
                }
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getExtras() {
        return this.extras;
    }

    public int getRequiredNetwork() {
        return this.requiredNetworkState;
    }

    public boolean getRequiresCharging() {
        return this.requiresCharging;
    }

    public String getServiceName() {
        return this.gcmTaskService;
    }

    public String getTag() {
        return this.tag;
    }

    public boolean isPersisted() {
        return this.isPersisted;
    }

    public boolean isUpdateCurrent() {
        return this.updateCurrent;
    }

    public void toBundle(Bundle bundle) {
        bundle.putString("tag", this.tag);
        bundle.putBoolean("update_current", this.updateCurrent);
        bundle.putBoolean("persisted", this.isPersisted);
        bundle.putString(NotificationCompat.CATEGORY_SERVICE, this.gcmTaskService);
        bundle.putInt("requiredNetwork", this.requiredNetworkState);
        if (!this.zzaw.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<Uri> it = this.zzaw.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toString());
            }
            bundle.putStringArrayList("reachabilityUris", arrayList);
        }
        bundle.putBoolean("requiresCharging", this.requiresCharging);
        bundle.putBoolean("requiresIdle", false);
        bundle.putBundle("retryStrategy", this.zzay.zzf(new Bundle()));
        bundle.putBundle("extras", this.extras);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.gcmTaskService);
        parcel.writeString(this.tag);
        parcel.writeInt(this.updateCurrent ? 1 : 0);
        parcel.writeInt(this.isPersisted ? 1 : 0);
    }
}
