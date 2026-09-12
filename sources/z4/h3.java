package z4;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class h3 extends l {

    /* renamed from: c, reason: collision with root package name */
    private final int f79356c;

    /* renamed from: d, reason: collision with root package name */
    private final List f79357d;

    /* renamed from: e, reason: collision with root package name */
    private final y4.a f79358e;

    /* renamed from: f, reason: collision with root package name */
    private final Object f79359f;

    /* renamed from: g, reason: collision with root package name */
    private final Map f79360g;

    /* renamed from: h, reason: collision with root package name */
    private final Collection f79361h;

    public h3(Collection collection) {
        super(null, null);
        this.f79358e = null;
        this.f79356c = -1;
        this.f79357d = null;
        this.f79359f = null;
        this.f79360g = null;
        this.f79361h = collection;
    }

    public h3(Map map, Object obj) {
        super(null, null);
        this.f79358e = null;
        this.f79356c = -1;
        this.f79357d = null;
        this.f79359f = obj;
        this.f79360g = map;
        this.f79361h = null;
    }

    public h3(y4.a aVar, List list, int i11) {
        super(null, null);
        this.f79358e = aVar;
        this.f79356c = i11;
        this.f79357d = list;
        this.f79359f = null;
        this.f79360g = null;
        this.f79361h = null;
    }

    @Override // z4.l
    public void d(y4.a aVar, Object obj, Type type, Map map) {
    }

    @Override // z4.l
    public void h(Object obj, Object obj2) {
        JSONArray jSONArray;
        Object relatedArray;
        Map map = this.f79360g;
        if (map != null) {
            map.put(this.f79359f, obj2);
            return;
        }
        Collection collection = this.f79361h;
        if (collection != null) {
            collection.add(obj2);
            return;
        }
        this.f79357d.set(this.f79356c, obj2);
        List list = this.f79357d;
        if (!(list instanceof JSONArray) || (relatedArray = (jSONArray = (JSONArray) list).getRelatedArray()) == null || Array.getLength(relatedArray) <= this.f79356c) {
            return;
        }
        if (jSONArray.getComponentType() != null) {
            obj2 = TypeUtils.h(obj2, jSONArray.getComponentType(), this.f79358e.m());
        }
        Array.set(relatedArray, this.f79356c, obj2);
    }
}
