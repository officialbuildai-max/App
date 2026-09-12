package kv;

import android.os.Build;
import com.transsion.transfer.wifi.bean.PermissionState;
import com.transsion.transfer.wifi.bean.ReportTransferAction;
import com.transsion.transfer.wifi.permission.PermissionsBean;
import com.transsion.transfer.wifi.permission.d;
import com.transsion.transfer.wifi.util.WifiUtils;
import com.transsion.transfer.wifi.util.g;
import hj.i;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f68519a = new c();

    private c() {
    }

    private final String a() {
        String simpleName = c.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final Map b(ReportTransferAction reportTransferAction) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(ReportTransferAction.REPORT_TRANSFER_ACTION.getAction(), reportTransferAction.getAction());
        linkedHashMap.put("is_p2p_supported", String.valueOf(WifiUtils.f56083a.q()));
        linkedHashMap.put("sdk_int", String.valueOf(Build.VERSION.SDK_INT));
        return linkedHashMap;
    }

    private final void c(Map map) {
        i.f64628a.s("wifi_p2p", "transfer", map);
    }

    public final void d() {
        Map b11 = b(ReportTransferAction.REPORT_TRANSFER_ACTION_CONNECT_CANCEL);
        g.f(g.f56093a, a() + " --> reportConnectWifiCancel() --> map = " + b11, false, 2, null);
        c(b11);
    }

    public final void e(int i11) {
        Map b11 = b(ReportTransferAction.REPORT_TRANSFER_ACTION_CONNECT_FAIL);
        b11.put("code", String.valueOf(i11));
        g.f(g.f56093a, a() + " --> reportConnectWifiFail() --> map = " + b11, false, 2, null);
        c(b11);
    }

    public final void f(long j11) {
        Map b11 = b(ReportTransferAction.REPORT_TRANSFER_ACTION_CONNECT_SUCCESS);
        b11.put("duration", String.valueOf(j11));
        g.f(g.f56093a, a() + " --> reportConnectWifiSuccess() --> map = " + b11, false, 2, null);
        c(b11);
    }

    public final void g() {
        Map b11 = b(ReportTransferAction.REPORT_TRANSFER_ACTION_CONNECT_TRIGGER);
        g.f(g.f56093a, a() + " --> reportConnectWifiTrigger() --> map = " + b11, false, 2, null);
        c(b11);
    }

    public final void h() {
        Map b11 = b(ReportTransferAction.REPORT_TRANSFER_ACTION_CREATE_CANCEL);
        g.f(g.f56093a, a() + " --> reportCreateWifiP2PCancel() --> map = " + b11, false, 2, null);
        c(b11);
    }

    public final void i(int i11) {
        Map b11 = b(ReportTransferAction.REPORT_TRANSFER_ACTION_CREATE_FAIL);
        b11.put("code", String.valueOf(i11));
        g.f(g.f56093a, a() + " --> reportCreateWifiP2PFail() --> map = " + b11, false, 2, null);
        c(b11);
    }

    public final void j(long j11, long j12) {
        Map b11 = b(ReportTransferAction.REPORT_TRANSFER_ACTION_CREATE_SUCCESS);
        b11.put("duration", String.valueOf(j11));
        b11.put("qr_duration", String.valueOf(j12));
        g.f(g.f56093a, a() + " --> reportCreateWifiP2PSuccess() --> map = " + b11, false, 2, null);
        c(b11);
    }

    public final void k() {
        Map b11 = b(ReportTransferAction.REPORT_TRANSFER_ACTION_CREATE_TRIGGER);
        g.f(g.f56093a, a() + " --> reportCreateWifiP2PTrigger() --> map = " + b11, false, 2, null);
        c(b11);
    }

    public final void l(String str, String permissions, PermissionState permissionsState) {
        Intrinsics.h(permissions, "permissions");
        Intrinsics.h(permissionsState, "permissionsState");
        Map b11 = b(ReportTransferAction.REPORT_TRANSFER_ACTION_PERMISSION_REQUEST);
        b11.put("user_role", Intrinsics.c(str, "com.transsion.transfer.wifi.util.send") ? "sender" : "receiver");
        b11.put("permissions", permissions);
        b11.put("state", permissionsState.getState());
    }

    public final void m(String str) {
        String str2;
        Map b11 = b(ReportTransferAction.REPORT_TRANSFER_ACTION_PERMISSION_PAGE_PV);
        if (Intrinsics.c(str, "com.transsion.transfer.wifi.util.send")) {
            for (PermissionsBean permissionsBean : d.f56029a.e()) {
                b11.put(permissionsBean.getPermission(), permissionsBean.getState().getState());
            }
            str2 = "sender";
        } else {
            for (PermissionsBean permissionsBean2 : d.f56029a.c()) {
                b11.put(permissionsBean2.getPermission(), permissionsBean2.getState().getState());
            }
            str2 = "receiver";
        }
        b11.put("user_role", str2);
        g.f(g.f56093a, a() + " --> reportPermission() --> map = " + b11, false, 2, null);
        c(b11);
    }

    public final void n() {
        Map b11 = b(ReportTransferAction.REPORT_TRANSFER_ACTION_SHARE_APK_DIALOG);
        g.f(g.f56093a, a() + " --> reportShareApkDialogShow() --> map = " + b11, false, 2, null);
        c(b11);
    }
}
