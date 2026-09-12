package com.cloud.tmc.integration.utils;

import android.graphics.Point;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.mbridge.msdk.MBridgeConstans;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/cloud/tmc/integration/utils/TouchEventUtils;", "", "()V", "TAG", "", "simulateTouchEvent", "", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/view/View;", "points", "", "Landroid/graphics/Point;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class TouchEventUtils {
    public static final TouchEventUtils INSTANCE = new TouchEventUtils();
    private static final String TAG = "TouchEventUtils";

    private TouchEventUtils() {
    }

    @JvmStatic
    public static final void simulateTouchEvent(View view, List<Point> points) {
        String str;
        String str2;
        String str3;
        String str4;
        Iterator it;
        long j11;
        int i11;
        Point point;
        View view2;
        View view3 = view;
        Intrinsics.h(view3, "view");
        Intrinsics.h(points, "points");
        long uptimeMillis = SystemClock.uptimeMillis();
        Iterator it2 = points.iterator();
        int i12 = 0;
        while (it2.hasNext()) {
            Object next = it2.next();
            int i13 = i12 + 1;
            if (i12 < 0) {
                CollectionsKt.u();
            }
            Point point2 = (Point) next;
            if (i12 == 0) {
                long j12 = uptimeMillis + 50;
                str4 = " eventTime: ";
                boolean dispatchTouchEvent = view3.dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, j12, 0, point2.x, point2.y, 0));
                int i14 = point2.x;
                int i15 = point2.y;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("simulateTouchEvent: ACTION_DOWN ");
                sb2.append(dispatchTouchEvent);
                str2 = " x: ";
                sb2.append(str2);
                sb2.append(i14);
                str3 = " y: ";
                sb2.append(str3);
                sb2.append(i15);
                sb2.append(" downTime: ");
                sb2.append(uptimeMillis);
                sb2.append(str4);
                sb2.append(j12);
                String sb3 = sb2.toString();
                str = TAG;
                TmcLogger.d(str, sb3);
            } else {
                str = TAG;
                str2 = " x: ";
                str3 = " y: ";
                str4 = " eventTime: ";
            }
            if (i12 == 0 || i12 == points.size() - 1) {
                it = it2;
                j11 = uptimeMillis;
                i11 = i13;
                point = point2;
            } else {
                long j13 = (i12 * 50) + uptimeMillis;
                long j14 = (i13 * 50) + uptimeMillis;
                it = it2;
                i11 = i13;
                boolean dispatchTouchEvent2 = view3.dispatchTouchEvent(MotionEvent.obtain(j13, j14, 2, point2.x, point2.y, 0));
                int i16 = point2.x;
                int i17 = point2.y;
                point = point2;
                StringBuilder sb4 = new StringBuilder();
                j11 = uptimeMillis;
                sb4.append("simulateTouchEvent: ACTION_MOVE ");
                sb4.append(dispatchTouchEvent2);
                sb4.append(str2);
                sb4.append(i16);
                sb4.append(str3);
                sb4.append(i17);
                sb4.append("  downTime: ");
                sb4.append(j13);
                sb4.append(str4);
                sb4.append(j14);
                TmcLogger.d(str, sb4.toString());
            }
            if (i12 == points.size() - 1) {
                long j15 = j11 + (i12 * 50);
                long j16 = j11 + (i11 * 50);
                Point point3 = point;
                view2 = view;
                TmcLogger.d(str, "simulateTouchEvent: ACTION_UP " + view2.dispatchTouchEvent(MotionEvent.obtain(j15, j16, 1, point3.x, point3.y, 0)) + str2 + point3.x + str3 + point3.y + "  downTime: " + j15 + str4 + j16);
            } else {
                view2 = view;
            }
            view3 = view2;
            it2 = it;
            i12 = i11;
            uptimeMillis = j11;
        }
    }
}
