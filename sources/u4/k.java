package u4;

import com.airbnb.lottie.parser.moshi.JsonReader;

/* loaded from: classes2.dex */
public class k {

    /* renamed from: f, reason: collision with root package name */
    private static final JsonReader.a f76769f = JsonReader.a.a("ef");

    /* renamed from: g, reason: collision with root package name */
    private static final JsonReader.a f76770g = JsonReader.a.a("nm", "v");

    /* renamed from: a, reason: collision with root package name */
    private q4.a f76771a;

    /* renamed from: b, reason: collision with root package name */
    private q4.b f76772b;

    /* renamed from: c, reason: collision with root package name */
    private q4.b f76773c;

    /* renamed from: d, reason: collision with root package name */
    private q4.b f76774d;

    /* renamed from: e, reason: collision with root package name */
    private q4.b f76775e;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0060, code lost:
    
        switch(r3) {
            case 0: goto L50;
            case 1: goto L49;
            case 2: goto L48;
            case 3: goto L47;
            case 4: goto L46;
            default: goto L51;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0067, code lost:
    
        r5.f76775e = u4.d.e(r6, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006e, code lost:
    
        r5.f76771a = u4.d.c(r6, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0075, code lost:
    
        r5.f76773c = u4.d.f(r6, r7, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x007c, code lost:
    
        r5.f76772b = u4.d.f(r6, r7, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0083, code lost:
    
        r5.f76774d = u4.d.e(r6, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0063, code lost:
    
        r6.x();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(com.airbnb.lottie.parser.moshi.JsonReader r6, com.airbnb.lottie.h r7) {
        /*
            r5 = this;
            r0 = 0
            r1 = 1
            r6.h()
            java.lang.String r2 = ""
        L7:
            boolean r3 = r6.m()
            if (r3 == 0) goto L91
            com.airbnb.lottie.parser.moshi.JsonReader$a r3 = u4.k.f76770g
            int r3 = r6.v(r3)
            if (r3 == 0) goto L8b
            if (r3 == r1) goto L1e
            r6.w()
            r6.x()
            goto L7
        L1e:
            r2.hashCode()
            r3 = -1
            int r4 = r2.hashCode()
            switch(r4) {
                case 353103893: goto L56;
                case 397447147: goto L4b;
                case 1041377119: goto L40;
                case 1379387491: goto L35;
                case 1383710113: goto L2a;
                default: goto L29;
            }
        L29:
            goto L60
        L2a:
            java.lang.String r4 = "Softness"
            boolean r4 = r2.equals(r4)
            if (r4 != 0) goto L33
            goto L60
        L33:
            r3 = 4
            goto L60
        L35:
            java.lang.String r4 = "Shadow Color"
            boolean r4 = r2.equals(r4)
            if (r4 != 0) goto L3e
            goto L60
        L3e:
            r3 = 3
            goto L60
        L40:
            java.lang.String r4 = "Direction"
            boolean r4 = r2.equals(r4)
            if (r4 != 0) goto L49
            goto L60
        L49:
            r3 = 2
            goto L60
        L4b:
            java.lang.String r4 = "Opacity"
            boolean r4 = r2.equals(r4)
            if (r4 != 0) goto L54
            goto L60
        L54:
            r3 = r1
            goto L60
        L56:
            java.lang.String r4 = "Distance"
            boolean r4 = r2.equals(r4)
            if (r4 != 0) goto L5f
            goto L60
        L5f:
            r3 = r0
        L60:
            switch(r3) {
                case 0: goto L83;
                case 1: goto L7c;
                case 2: goto L75;
                case 3: goto L6e;
                case 4: goto L67;
                default: goto L63;
            }
        L63:
            r6.x()
            goto L7
        L67:
            q4.b r3 = u4.d.e(r6, r7)
            r5.f76775e = r3
            goto L7
        L6e:
            q4.a r3 = u4.d.c(r6, r7)
            r5.f76771a = r3
            goto L7
        L75:
            q4.b r3 = u4.d.f(r6, r7, r0)
            r5.f76773c = r3
            goto L7
        L7c:
            q4.b r3 = u4.d.f(r6, r7, r0)
            r5.f76772b = r3
            goto L7
        L83:
            q4.b r3 = u4.d.e(r6, r7)
            r5.f76774d = r3
            goto L7
        L8b:
            java.lang.String r2 = r6.r()
            goto L7
        L91:
            r6.l()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u4.k.a(com.airbnb.lottie.parser.moshi.JsonReader, com.airbnb.lottie.h):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j b(JsonReader jsonReader, com.airbnb.lottie.h hVar) {
        q4.b bVar;
        q4.b bVar2;
        q4.b bVar3;
        q4.b bVar4;
        while (jsonReader.m()) {
            if (jsonReader.v(f76769f) != 0) {
                jsonReader.w();
                jsonReader.x();
            } else {
                jsonReader.d();
                while (jsonReader.m()) {
                    a(jsonReader, hVar);
                }
                jsonReader.k();
            }
        }
        q4.a aVar = this.f76771a;
        if (aVar == null || (bVar = this.f76772b) == null || (bVar2 = this.f76773c) == null || (bVar3 = this.f76774d) == null || (bVar4 = this.f76775e) == null) {
            return null;
        }
        return new j(aVar, bVar, bVar2, bVar3, bVar4);
    }
}
