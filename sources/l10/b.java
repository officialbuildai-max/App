package l10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.script.ScriptEngineFactory;

/* loaded from: classes7.dex */
public class b implements ScriptEngineFactory {

    /* renamed from: a, reason: collision with root package name */
    private static final List f68600a;

    /* renamed from: b, reason: collision with root package name */
    private static final List f68601b;

    /* renamed from: c, reason: collision with root package name */
    private static final List f68602c;

    /* renamed from: d, reason: collision with root package name */
    private static final a f68603d;

    static {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add("mvel");
        List unmodifiableList = Collections.unmodifiableList(arrayList);
        f68600a = unmodifiableList;
        f68601b = unmodifiableList;
        ArrayList arrayList2 = new ArrayList(1);
        arrayList2.add("application/x-mvel");
        f68602c = Collections.unmodifiableList(arrayList2);
        f68603d = new a();
    }
}
