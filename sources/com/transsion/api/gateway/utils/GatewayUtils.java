package com.transsion.api.gateway.utils;

import android.text.TextUtils;
import com.transsion.api.gateway.GateWaySdk;
import com.transsion.api.gateway.bean.GatewayHost;
import com.transsion.api.gateway.config.b;
import com.transsion.api.gateway.utils.ObjectLogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class GatewayUtils {
    public static ObjectLogUtils L = new ObjectLogUtils.Builder().setGlobalTag("gateway_sdk").setLogSwitch(false).setLogHeadSwitch(false).setBorderSwitch(false).create();

    public static boolean canUseGateWay(String str) {
        List list;
        if (b.a().f42568a.f42547b && (list = b.a().f42568a.f42555j) != null && !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((GatewayHost) it.next()).host.contains(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean canUseGateWay(String str, String str2) {
        List list;
        boolean z10;
        if (!b.a().f42568a.f42547b || b.a().f42568a.f42556k.size() == 0 || (list = b.a().f42568a.f42555j) == null || list.isEmpty()) {
            return false;
        }
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z10 = false;
                break;
            }
            GatewayHost gatewayHost = (GatewayHost) it.next();
            if (gatewayHost.host.contains(str)) {
                arrayList = gatewayHost.enablePath;
                arrayList2 = gatewayHost.disablePath;
                z10 = true;
                break;
            }
        }
        if (!z10) {
            return false;
        }
        if (arrayList.size() == 0 && arrayList2.size() == 0) {
            return true;
        }
        if (arrayList.size() <= 0 || !arrayList.contains(str2)) {
            return arrayList2.size() > 0 && !arrayList2.contains(str2);
        }
        return true;
    }

    public static boolean isExcludeRequest(String str) {
        return TextUtils.isEmpty(str) || str.contains("/gateway/sdk/v1/config?app=") || str.contains("/gateway/metric/add");
    }

    public static boolean isRequireSign(String str, String str2) {
        List<String> activateSigHosts = GateWaySdk.getActivateSigHosts();
        List<String> activateSigPaths = GateWaySdk.getActivateSigPaths();
        if (activateSigHosts != null && activateSigHosts.size() > 0) {
            Iterator<String> it = activateSigHosts.iterator();
            while (it.hasNext()) {
                if (str.contains(it.next())) {
                    return true;
                }
            }
        }
        if (activateSigPaths == null || activateSigPaths.size() <= 0) {
            return false;
        }
        Iterator<String> it2 = activateSigPaths.iterator();
        while (it2.hasNext()) {
            if (str2.contains(it2.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0069, code lost:
    
        if (r11 != 3) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] textToNumericFormatV4(java.lang.String r16) {
        /*
            r0 = 4
            byte[] r0 = new byte[r0]
            int r1 = r16.length()
            r2 = 0
            if (r1 == 0) goto L8e
            r3 = 15
            if (r1 > r3) goto L8e
            r3 = 0
            r9 = r3
            r7 = 0
            r8 = 1
            r11 = 0
        L14:
            r12 = 3
            r13 = 255(0xff, double:1.26E-321)
            if (r7 >= r1) goto L4f
            r15 = r16
            char r5 = r15.charAt(r7)
            r6 = 46
            if (r5 != r6) goto L3d
            if (r8 != 0) goto L3c
            int r5 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r5 < 0) goto L3c
            int r5 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r5 > 0) goto L3c
            if (r11 != r12) goto L30
            goto L3c
        L30:
            int r5 = r11 + 1
            long r8 = r9 & r13
            int r6 = (int) r8
            byte r6 = (byte) r6
            r0[r11] = r6
            r9 = r3
            r11 = r5
            r8 = 1
            goto L4c
        L3c:
            return r2
        L3d:
            r6 = 10
            int r5 = java.lang.Character.digit(r5, r6)
            if (r5 >= 0) goto L46
            return r2
        L46:
            r12 = 10
            long r9 = r9 * r12
            long r5 = (long) r5
            long r9 = r9 + r5
            r8 = 0
        L4c:
            int r7 = r7 + 1
            goto L14
        L4f:
            if (r8 != 0) goto L8e
            int r1 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r1 < 0) goto L8e
            int r1 = 4 - r11
            r3 = 8
            int r1 = r1 * r3
            r4 = 1
            long r4 = r4 << r1
            int r1 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r1 >= 0) goto L8e
            r1 = 2
            if (r11 == 0) goto L6c
            r2 = 1
            if (r11 == r2) goto L76
            if (r11 == r1) goto L80
            if (r11 == r12) goto L87
            goto L8d
        L6c:
            r2 = 24
            long r4 = r9 >> r2
            long r4 = r4 & r13
            int r2 = (int) r4
            byte r2 = (byte) r2
            r4 = 0
            r0[r4] = r2
        L76:
            r2 = 16
            long r4 = r9 >> r2
            long r4 = r4 & r13
            int r2 = (int) r4
            byte r2 = (byte) r2
            r4 = 1
            r0[r4] = r2
        L80:
            long r2 = r9 >> r3
            long r2 = r2 & r13
            int r2 = (int) r2
            byte r2 = (byte) r2
            r0[r1] = r2
        L87:
            long r1 = r9 & r13
            int r1 = (int) r1
            byte r1 = (byte) r1
            r0[r12] = r1
        L8d:
            return r0
        L8e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.api.gateway.utils.GatewayUtils.textToNumericFormatV4(java.lang.String):byte[]");
    }
}
