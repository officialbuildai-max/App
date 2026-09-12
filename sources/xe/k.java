package xe;

import com.google.zxing.DecodeHintType;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class k implements h {

    /* renamed from: a, reason: collision with root package name */
    private Collection f78344a;

    /* renamed from: b, reason: collision with root package name */
    private Map f78345b;

    /* renamed from: c, reason: collision with root package name */
    private String f78346c;

    /* renamed from: d, reason: collision with root package name */
    private int f78347d;

    public k() {
    }

    public k(Collection collection) {
        this.f78344a = collection;
    }

    public k(Collection collection, Map map, String str, int i11) {
        this.f78344a = collection;
        this.f78345b = map;
        this.f78346c = str;
        this.f78347d = i11;
    }

    @Override // xe.h
    public g a(Map map) {
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        enumMap.putAll(map);
        Map map2 = this.f78345b;
        if (map2 != null) {
            enumMap.putAll(map2);
        }
        Collection collection = this.f78344a;
        if (collection != null) {
            enumMap.put((EnumMap) DecodeHintType.POSSIBLE_FORMATS, (DecodeHintType) collection);
        }
        String str = this.f78346c;
        if (str != null) {
            enumMap.put((EnumMap) DecodeHintType.CHARACTER_SET, (DecodeHintType) str);
        }
        com.google.zxing.f fVar = new com.google.zxing.f();
        fVar.e(enumMap);
        int i11 = this.f78347d;
        return i11 != 0 ? i11 != 1 ? i11 != 2 ? new g(fVar) : new m(fVar) : new l(fVar) : new g(fVar);
    }
}
