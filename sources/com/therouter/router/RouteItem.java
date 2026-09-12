package com.therouter.router;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.cloud.tmc.integration.event.EventConstants;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Keep
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 62\u00020\u00012\u00020\u0002:\u00017B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0003\u0010\u0007B)\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\u0003\u0010\rJ\u001d\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0018\u001a\u00020\u0013¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010#\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u001eH\u0016¢\u0006\u0004\b#\u0010$J\u0015\u0010&\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0005¢\u0006\u0004\b&\u0010\u0007R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010'\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010*R\"\u0010\n\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010'\u001a\u0004\b+\u0010\u001b\"\u0004\b,\u0010*R\"\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010'\u001a\u0004\b-\u0010\u001b\"\u0004\b.\u0010*R\"\u0010\f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010'\u001a\u0004\b/\u0010\u001b\"\u0004\b0\u0010*R\"\u00102\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105¨\u00068"}, d2 = {"Lcom/therouter/router/RouteItem;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "<init>", "()V", "Landroid/os/Parcel;", TtmlNode.TAG_P, "(Landroid/os/Parcel;)V", "", "path", "className", EventConstants.KEY_ACTION, TrackingKey.DESCRIPTION, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "key", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "addParams", "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Bundle;", "bundle", "addAll$router_release", "(Landroid/os/Bundle;)Lkotlin/Unit;", "addAll", "getExtras", "()Landroid/os/Bundle;", "toString", "()Ljava/lang/String;", "copy", "()Lcom/therouter/router/RouteItem;", "", "describeContents", "()I", "dest", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", EventConstants.KEY_SOURCE, "readFromParcel", "Ljava/lang/String;", "getPath", "setPath", "(Ljava/lang/String;)V", "getClassName", "setClassName", "getAction", "setAction", "getDescription", "setDescription", "Ljava/util/HashMap;", "params", "Ljava/util/HashMap;", "extras", "Landroid/os/Bundle;", "CREATOR", "a", "router_release"}, k = 1, mv = {1, 9, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes5.dex */
public final class RouteItem implements Parcelable, Serializable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String action;
    private String className;
    private String description;
    private Bundle extras;
    private HashMap<String, String> params;
    private String path;

    /* renamed from: com.therouter.router.RouteItem$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion implements Parcelable.Creator {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RouteItem createFromParcel(Parcel parcel) {
            Intrinsics.h(parcel, "parcel");
            return new RouteItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RouteItem[] newArray(int i11) {
            return new RouteItem[i11];
        }
    }

    public RouteItem() {
        this.path = "";
        this.className = "";
        this.action = "";
        this.description = "";
        this.params = new HashMap<>();
        this.extras = new Bundle();
    }

    public RouteItem(Parcel p11) {
        Intrinsics.h(p11, "p");
        this.path = "";
        this.className = "";
        this.action = "";
        this.description = "";
        this.params = new HashMap<>();
        this.extras = new Bundle();
        String readString = p11.readString();
        this.path = readString == null ? "" : readString;
        String readString2 = p11.readString();
        this.className = readString2 == null ? "" : readString2;
        String readString3 = p11.readString();
        this.action = readString3 == null ? "" : readString3;
        String readString4 = p11.readString();
        this.description = readString4 != null ? readString4 : "";
        Serializable readSerializable = p11.readSerializable();
        this.params = readSerializable instanceof HashMap ? (HashMap) readSerializable : new HashMap<>();
        Bundle readBundle = p11.readBundle(ClassLoader.getSystemClassLoader());
        this.extras = readBundle == null ? new Bundle() : readBundle;
    }

    public RouteItem(String path, String className, String action, String description) {
        Intrinsics.h(path, "path");
        Intrinsics.h(className, "className");
        Intrinsics.h(action, "action");
        Intrinsics.h(description, "description");
        this.path = "";
        this.className = "";
        this.action = "";
        this.description = "";
        this.params = new HashMap<>();
        this.extras = new Bundle();
        this.path = path;
        this.className = className;
        this.action = action;
        this.description = description;
    }

    public final Unit addAll$router_release(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        this.extras.putAll(bundle);
        return Unit.f67184a;
    }

    public final void addParams(String key, String value) {
        Intrinsics.h(key, "key");
        Intrinsics.h(value, "value");
        this.extras.putString(key, value);
    }

    public final RouteItem copy() {
        RouteItem routeItem = new RouteItem();
        routeItem.extras.putAll(this.extras);
        routeItem.params.putAll(this.params);
        routeItem.description = this.description;
        routeItem.action = this.action;
        routeItem.className = this.className;
        routeItem.path = this.path;
        return routeItem;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getAction() {
        return this.action;
    }

    public final String getClassName() {
        return this.className;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Bundle getExtras() {
        for (Map.Entry<String, String> entry : this.params.entrySet()) {
            if (!this.extras.keySet().contains(entry.getKey())) {
                this.extras.putString(entry.getKey(), entry.getValue());
            }
        }
        return this.extras;
    }

    public final String getPath() {
        return this.path;
    }

    public final void readFromParcel(Parcel source) {
        Intrinsics.h(source, "source");
        String readString = source.readString();
        Intrinsics.e(readString);
        this.path = readString;
        String readString2 = source.readString();
        Intrinsics.e(readString2);
        this.className = readString2;
        String readString3 = source.readString();
        Intrinsics.e(readString3);
        this.action = readString3;
        String readString4 = source.readString();
        Intrinsics.e(readString4);
        this.description = readString4;
        Serializable readSerializable = source.readSerializable();
        this.params = readSerializable instanceof HashMap ? (HashMap) readSerializable : new HashMap<>();
        Bundle readBundle = source.readBundle(RouteItem.class.getClassLoader());
        if (readBundle == null) {
            readBundle = new Bundle();
        }
        this.extras = readBundle;
    }

    public final void setAction(String str) {
        Intrinsics.h(str, "<set-?>");
        this.action = str;
    }

    public final void setClassName(String str) {
        Intrinsics.h(str, "<set-?>");
        this.className = str;
    }

    public final void setDescription(String str) {
        Intrinsics.h(str, "<set-?>");
        this.description = str;
    }

    public final void setPath(String str) {
        Intrinsics.h(str, "<set-?>");
        this.path = str;
    }

    public String toString() {
        return "RouteItem(path='" + this.path + "', className='" + this.className + "', action='" + this.action + "', description='" + this.description + "', extras=" + this.extras + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        Intrinsics.h(dest, "dest");
        dest.writeString(this.path);
        dest.writeString(this.className);
        dest.writeString(this.action);
        dest.writeString(this.description);
        dest.writeSerializable(this.params);
        dest.writeBundle(this.extras);
    }
}
