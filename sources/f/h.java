package f;

import android.content.Context;
import android.content.Intent;
import f.a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes2.dex */
public final class h extends f.a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f62242a = new a(null);

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(String[] input) {
            Intrinsics.h(input, "input");
            Intent putExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", input);
            Intrinsics.g(putExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
            return putExtra;
        }
    }

    @Override // f.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, String[] input) {
        Intrinsics.h(context, "context");
        Intrinsics.h(input, "input");
        return f62242a.a(input);
    }

    @Override // f.a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public a.C0777a b(Context context, String[] input) {
        Intrinsics.h(context, "context");
        Intrinsics.h(input, "input");
        if (input.length == 0) {
            return new a.C0777a(MapsKt.h());
        }
        for (String str : input) {
            if (androidx.core.content.b.checkSelfPermission(context, str) != 0) {
                return null;
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.e(input.length), 16));
        for (String str2 : input) {
            Pair a11 = TuplesKt.a(str2, Boolean.TRUE);
            linkedHashMap.put(a11.getFirst(), a11.getSecond());
        }
        return new a.C0777a(linkedHashMap);
    }

    @Override // f.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Map c(int i11, Intent intent) {
        if (i11 == -1 && intent != null) {
            String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            if (intArrayExtra == null || stringArrayExtra == null) {
                return MapsKt.h();
            }
            ArrayList arrayList = new ArrayList(intArrayExtra.length);
            for (int i12 : intArrayExtra) {
                arrayList.add(Boolean.valueOf(i12 == 0));
            }
            return MapsKt.s(CollectionsKt.Z0(ArraysKt.S(stringArrayExtra), arrayList));
        }
        return MapsKt.h();
    }
}
