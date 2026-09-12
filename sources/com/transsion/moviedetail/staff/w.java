package com.transsion.moviedetail.staff;

import android.os.SystemClock;
import android.util.SparseArray;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.transsion.moviedetailapi.bean.Staff;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class w {

    /* renamed from: c, reason: collision with root package name */
    private List f47403c;

    /* renamed from: a, reason: collision with root package name */
    private int f47401a = -1;

    /* renamed from: b, reason: collision with root package name */
    private int f47402b = -1;

    /* renamed from: d, reason: collision with root package name */
    private SparseArray f47404d = new SparseArray();

    /* renamed from: e, reason: collision with root package name */
    private HashSet f47405e = new HashSet();

    public final int a() {
        return this.f47401a;
    }

    public final int b() {
        return this.f47402b;
    }

    public final void c(int i11, long j11) {
        String str;
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("reportBrowseEvent  staff----  position:");
            sb2.append(i11);
            sb2.append("  duration:");
            sb2.append(j11);
            List list = this.f47403c;
            Staff staff = list != null ? (Staff) list.get(i11) : null;
            if (this.f47405e.add(staff != null ? staff.getStaffId() : null)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("item_type", "staff");
                if (staff == null || (str = staff.getStaffId()) == null) {
                    str = "";
                }
                linkedHashMap.put("staff_id", str);
                linkedHashMap.put(RequestParameters.POSITION, String.valueOf(i11));
                linkedHashMap.put("browse_duration", String.valueOf(j11));
                com.transsion.baselib.helper.a.f43316a.e("staff_info", linkedHashMap);
            }
        } catch (Exception unused) {
        }
    }

    public final void d(int i11, int i12) {
        int i13 = this.f47401a;
        if (i13 == i11 && this.f47402b == i12) {
            return;
        }
        if (i13 >= 0 && this.f47402b >= 0) {
            ArrayList arrayList = new ArrayList();
            IntIterator a11 = androidx.core.util.k.a(this.f47404d);
            while (a11.hasNext()) {
                int intValue = a11.next().intValue();
                if (i11 > intValue || intValue > i12) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    Object obj = this.f47404d.get(intValue);
                    Intrinsics.g(obj, "get(...)");
                    c(intValue, elapsedRealtime - ((Number) obj).longValue());
                    arrayList.add(Integer.valueOf(intValue));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.f47404d.remove(((Number) it.next()).intValue());
            }
            if (i11 <= i12) {
                int i14 = i11;
                while (true) {
                    if (this.f47404d.get(i14) == null) {
                        this.f47404d.put(i14, Long.valueOf(SystemClock.elapsedRealtime()));
                    }
                    if (i14 == i12) {
                        break;
                    } else {
                        i14++;
                    }
                }
            }
        } else if (i11 <= i12) {
            int i15 = i11;
            while (true) {
                this.f47404d.put(i15, Long.valueOf(SystemClock.elapsedRealtime()));
                if (i15 == i12) {
                    break;
                } else {
                    i15++;
                }
            }
        }
        this.f47401a = i11;
        this.f47402b = i12;
    }

    public final void e(List list) {
        this.f47403c = list;
    }
}
