package n4;

import com.airbnb.lottie.model.DocumentData;
import java.util.List;

/* loaded from: classes2.dex */
public class o extends g {

    /* loaded from: classes2.dex */
    class a extends w4.c {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ w4.b f70351d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ w4.c f70352e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ DocumentData f70353f;

        a(w4.b bVar, w4.c cVar, DocumentData documentData) {
            this.f70351d = bVar;
            this.f70352e = cVar;
            this.f70353f = documentData;
        }

        @Override // w4.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public DocumentData a(w4.b bVar) {
            this.f70351d.h(bVar.f(), bVar.a(), ((DocumentData) bVar.g()).f17852a, ((DocumentData) bVar.b()).f17852a, bVar.d(), bVar.c(), bVar.e());
            String str = (String) this.f70352e.a(this.f70351d);
            DocumentData documentData = (DocumentData) (bVar.c() == 1.0f ? bVar.b() : bVar.g());
            this.f70353f.a(str, documentData.f17853b, documentData.f17854c, documentData.f17855d, documentData.f17856e, documentData.f17857f, documentData.f17858g, documentData.f17859h, documentData.f17860i, documentData.f17861j, documentData.f17862k, documentData.f17863l, documentData.f17864m);
            return this.f70353f;
        }
    }

    public o(List list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // n4.a
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public DocumentData i(w4.a aVar, float f11) {
        Object obj;
        w4.c cVar = this.f70303e;
        if (cVar == null) {
            return (f11 != 1.0f || (obj = aVar.f77688c) == null) ? (DocumentData) aVar.f77687b : (DocumentData) obj;
        }
        float f12 = aVar.f77692g;
        Float f13 = aVar.f77693h;
        float floatValue = f13 == null ? Float.MAX_VALUE : f13.floatValue();
        Object obj2 = aVar.f77687b;
        DocumentData documentData = (DocumentData) obj2;
        Object obj3 = aVar.f77688c;
        return (DocumentData) cVar.b(f12, floatValue, documentData, obj3 == null ? (DocumentData) obj2 : (DocumentData) obj3, f11, d(), f());
    }

    public void r(w4.c cVar) {
        super.o(new a(new w4.b(), cVar, new DocumentData()));
    }
}
