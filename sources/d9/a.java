package d9;

import android.util.SparseArray;
import com.google.android.datatransport.Priority;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static SparseArray f61368a = new SparseArray();

    /* renamed from: b, reason: collision with root package name */
    private static HashMap f61369b;

    static {
        HashMap hashMap = new HashMap();
        f61369b = hashMap;
        hashMap.put(Priority.DEFAULT, 0);
        f61369b.put(Priority.VERY_LOW, 1);
        f61369b.put(Priority.HIGHEST, 2);
        for (Priority priority : f61369b.keySet()) {
            f61368a.append(((Integer) f61369b.get(priority)).intValue(), priority);
        }
    }

    public static int a(Priority priority) {
        Integer num = (Integer) f61369b.get(priority);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + priority);
    }

    public static Priority b(int i11) {
        Priority priority = (Priority) f61368a.get(i11);
        if (priority != null) {
            return priority;
        }
        throw new IllegalArgumentException("Unknown Priority for value " + i11);
    }
}
