package ye;

import android.os.Build;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import cf.h;
import cf.o0;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private FragmentActivity f79114a;

    /* renamed from: b, reason: collision with root package name */
    private Fragment f79115b;

    public a(FragmentActivity activity) {
        Intrinsics.h(activity, "activity");
        this.f79114a = activity;
    }

    public final h a(List permissions) {
        int i11;
        Intrinsics.h(permissions, "permissions");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        int i12 = Build.VERSION.SDK_INT;
        FragmentActivity fragmentActivity = this.f79114a;
        if (fragmentActivity != null) {
            Intrinsics.e(fragmentActivity);
            i11 = fragmentActivity.getApplicationInfo().targetSdkVersion;
        } else {
            Fragment fragment = this.f79115b;
            Intrinsics.e(fragment);
            i11 = fragment.requireContext().getApplicationInfo().targetSdkVersion;
        }
        Iterator it = permissions.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (bf.b.a().contains(str)) {
                linkedHashSet2.add(str);
            } else {
                linkedHashSet.add(str);
            }
        }
        if (linkedHashSet2.contains("android.permission.ACCESS_BACKGROUND_LOCATION") && (i12 == 29 || (i12 == 30 && i11 < 30))) {
            linkedHashSet2.remove("android.permission.ACCESS_BACKGROUND_LOCATION");
            linkedHashSet.add("android.permission.ACCESS_BACKGROUND_LOCATION");
        }
        if (linkedHashSet2.contains("android.permission.POST_NOTIFICATIONS") && i12 >= 33 && i11 >= 33) {
            linkedHashSet2.remove("android.permission.POST_NOTIFICATIONS");
            linkedHashSet.add("android.permission.POST_NOTIFICATIONS");
        }
        return new o0(this.f79114a, this.f79115b, linkedHashSet, linkedHashSet2);
    }

    public final h b(String... permissions) {
        Intrinsics.h(permissions, "permissions");
        return a(CollectionsKt.o(Arrays.copyOf(permissions, permissions.length)));
    }
}
