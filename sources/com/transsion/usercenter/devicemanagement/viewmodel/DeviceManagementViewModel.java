package com.transsion.usercenter.devicemanagement.viewmodel;

import androidx.view.LiveData;
import androidx.view.b0;
import androidx.view.t0;
import androidx.view.u0;
import com.transsion.baselib.locale.d;
import com.transsion.usercenter.R$drawable;
import com.transsion.usercenter.devicemanagement.model.LinkedDeviceDto;
import com.transsion.usercenter.devicemanagement.model.UpgradeRightDto;
import com.transsion.usercenter.devicemanagement.repository.DeviceManagementRepository;
import ih.b;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import jw.e;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.k;

/* loaded from: classes6.dex */
public final class DeviceManagementViewModel extends t0 {

    /* renamed from: d, reason: collision with root package name */
    public static final a f56805d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final DeviceManagementRepository f56806a = new DeviceManagementRepository();

    /* renamed from: b, reason: collision with root package name */
    private final b0 f56807b;

    /* renamed from: c, reason: collision with root package name */
    private final LiveData f56808c;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public DeviceManagementViewModel() {
        b0 b0Var = new b0();
        this.f56807b = b0Var;
        this.f56808c = b0Var;
    }

    private final String h(Long l11) {
        if (l11 != null) {
            if (l11.longValue() <= 0) {
                l11 = null;
            }
            if (l11 != null) {
                return new SimpleDateFormat("dd/MM/yy", Locale.US).format(new Date(TimeUnit.SECONDS.toMillis(l11.longValue())));
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String i(String str) {
        if (str != null) {
            if (StringsKt.q0(str)) {
                str = null;
            }
            if (str != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
                simpleDateFormat.setLenient(false);
                ParsePosition parsePosition = new ParsePosition(0);
                Date parse = simpleDateFormat.parse(str, parsePosition);
                return (parse == null || parsePosition.getIndex() != str.length()) ? str : new SimpleDateFormat("MMM dd, yyyy", j()).format(parse);
            }
        }
        return null;
    }

    private final Locale j() {
        d.b bVar = d.f43351f;
        Locale j11 = bVar.e().j();
        if (j11 == null) {
            Locale ENGLISH = Locale.ENGLISH;
            Intrinsics.g(ENGLISH, "ENGLISH");
            return ENGLISH;
        }
        List S = ArraysKt.S(bVar.f());
        boolean z10 = false;
        if (!(S instanceof Collection) || !S.isEmpty()) {
            Iterator it = S.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (Intrinsics.c(new Locale((String) it.next()).getLanguage(), j11.getLanguage())) {
                    z10 = true;
                    break;
                }
            }
        }
        if (!z10) {
            j11 = null;
        }
        if (j11 != null) {
            return j11;
        }
        Locale ENGLISH2 = Locale.ENGLISH;
        Intrinsics.g(ENGLISH2, "ENGLISH");
        return ENGLISH2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int m(Integer num) {
        return RangesKt.f(num != null ? num.intValue() : 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final jw.d n(LinkedDeviceDto linkedDeviceDto) {
        int i11;
        String h11 = b.f65364a.h();
        String deviceId = linkedDeviceDto.getDeviceId();
        boolean z10 = deviceId != null && (StringsKt.q0(deviceId) ^ true) && Intrinsics.c(linkedDeviceDto.getDeviceId(), h11);
        String deviceName = linkedDeviceDto.getDeviceName();
        String str = deviceName == null ? "" : deviceName;
        String h12 = h(linkedDeviceDto.getLoginTimestamp());
        String icon = linkedDeviceDto.getIcon();
        String deviceName2 = linkedDeviceDto.getDeviceName();
        if (deviceName2 == null) {
            deviceName2 = "";
        }
        if (!StringsKt.a0(deviceName2, "tv", true)) {
            String deviceName3 = linkedDeviceDto.getDeviceName();
            if (deviceName3 == null) {
                deviceName3 = "";
            }
            if (!StringsKt.a0(deviceName3, "television", true)) {
                String deviceName4 = linkedDeviceDto.getDeviceName();
                if (deviceName4 == null) {
                    deviceName4 = "";
                }
                if (!StringsKt.a0(deviceName4, "web", true)) {
                    String deviceName5 = linkedDeviceDto.getDeviceName();
                    if (!StringsKt.a0(deviceName5 != null ? deviceName5 : "", "browser", true)) {
                        i11 = R$drawable.ic_device_linked_phone;
                        return new jw.d(str, h12, z10, icon, i11);
                    }
                }
                i11 = R$drawable.ic_device_linked_phone;
                return new jw.d(str, h12, z10, icon, i11);
            }
        }
        i11 = R$drawable.ic_device_linked_tv;
        return new jw.d(str, h12, z10, icon, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e o(UpgradeRightDto upgradeRightDto) {
        String featureIcon = upgradeRightDto.getFeatureIcon();
        String featureName = upgradeRightDto.getFeatureName();
        if (featureName == null) {
            featureName = "";
        }
        return new e(featureIcon, featureName, upgradeRightDto.getFeatureLink(), m(upgradeRightDto.getBasicCount()), m(upgradeRightDto.getProCount()));
    }

    public final LiveData k() {
        return this.f56808c;
    }

    public final void l() {
        k.d(u0.a(this), null, null, new DeviceManagementViewModel$loadData$1(this, null), 3, null);
    }
}
