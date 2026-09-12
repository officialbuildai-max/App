package mv;

import com.transsion.transfer.impl.entity.FileData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f70136a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final List f70137b = new ArrayList();

    private a() {
    }

    private final List c(int i11) {
        List list = f70137b;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((FileData) obj).getState() == i11) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.U0(arrayList);
    }

    public final void a(List data) {
        Object obj;
        Intrinsics.h(data, "data");
        Iterator it = data.iterator();
        while (it.hasNext()) {
            FileData fileData = (FileData) it.next();
            Iterator it2 = f70137b.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it2.next();
                    if (Intrinsics.c(((FileData) obj).getFileRemotePath(), fileData.getFileRemotePath())) {
                        break;
                    }
                }
            }
            if (obj == null) {
                f70137b.add(fileData);
            }
        }
    }

    public final void b() {
        f70137b.clear();
    }

    public final List d() {
        return f70137b;
    }

    public final List e() {
        return CollectionsKt.U0(CollectionsKt.B0(c(3), c(5)));
    }

    public final List f() {
        return CollectionsKt.U0(c(2));
    }

    public final List g() {
        return CollectionsKt.U0(c(0));
    }

    public final boolean h() {
        return f70137b.isEmpty();
    }
}
