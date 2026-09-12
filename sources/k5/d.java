package k5;

import java.util.Hashtable;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public String f66778a = "";

    /* renamed from: b, reason: collision with root package name */
    public String f66779b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f66780c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f66781d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f66782e = "";

    /* renamed from: f, reason: collision with root package name */
    public String f66783f = "";

    /* renamed from: k, reason: collision with root package name */
    public boolean f66788k = true;

    /* renamed from: l, reason: collision with root package name */
    public int f66789l = 0;

    /* renamed from: m, reason: collision with root package name */
    public boolean f66790m = false;

    /* renamed from: g, reason: collision with root package name */
    public Hashtable f66784g = new Hashtable();

    /* renamed from: h, reason: collision with root package name */
    public Hashtable f66785h = new Hashtable();

    /* renamed from: i, reason: collision with root package name */
    public TreeMap f66786i = new TreeMap();

    /* renamed from: j, reason: collision with root package name */
    public String f66787j = "List of non fatal errors produced during parsing:\n\n";

    public void a() {
        Hashtable hashtable = new Hashtable();
        for (b bVar : this.f66786i.values()) {
            a aVar = bVar.f66773a;
            if (aVar != null) {
                String str = aVar.f66764a;
                if (!hashtable.containsKey(str)) {
                    hashtable.put(str, bVar.f66773a);
                }
            }
        }
        this.f66784g = hashtable;
    }
}
