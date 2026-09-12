package kotlin.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes7.dex */
class b {
    private static final int a(String str) {
        int n02;
        char c11 = File.separatorChar;
        int n03 = StringsKt.n0(str, c11, 0, false, 4, null);
        if (n03 == 0) {
            if (str.length() <= 1 || str.charAt(1) != c11 || (n02 = StringsKt.n0(str, c11, 2, false, 4, null)) < 0) {
                return 1;
            }
            int n04 = StringsKt.n0(str, c11, n02 + 1, false, 4, null);
            return n04 >= 0 ? n04 + 1 : str.length();
        }
        if (n03 > 0 && str.charAt(n03 - 1) == ':') {
            return n03 + 1;
        }
        if (n03 == -1 && StringsKt.f0(str, ':', false, 2, null)) {
            return str.length();
        }
        return 0;
    }

    public static final FilePathComponents b(File file) {
        List list;
        Intrinsics.h(file, "<this>");
        String path = file.getPath();
        Intrinsics.e(path);
        int a11 = a(path);
        String substring = path.substring(0, a11);
        Intrinsics.g(substring, "substring(...)");
        String substring2 = path.substring(a11);
        Intrinsics.g(substring2, "substring(...)");
        if (substring2.length() == 0) {
            list = CollectionsKt.l();
        } else {
            List R0 = StringsKt.R0(substring2, new char[]{File.separatorChar}, false, 0, 6, null);
            ArrayList arrayList = new ArrayList(CollectionsKt.v(R0, 10));
            Iterator it = R0.iterator();
            while (it.hasNext()) {
                arrayList.add(new File((String) it.next()));
            }
            list = arrayList;
        }
        return new FilePathComponents(new File(substring), list);
    }
}
