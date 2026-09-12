package com.iab.omid.library.bytedance2.adsession;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.iab.omid.library.bytedance2.internal.c;
import com.iab.omid.library.bytedance2.internal.e;
import com.iab.omid.library.bytedance2.internal.f;
import com.iab.omid.library.bytedance2.internal.i;
import com.iab.omid.library.bytedance2.publisher.AdSessionStatePublisher;
import com.iab.omid.library.bytedance2.publisher.b;
import com.iab.omid.library.bytedance2.utils.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class a extends AdSession {

    /* renamed from: a, reason: collision with root package name */
    private final AdSessionContext f33461a;

    /* renamed from: b, reason: collision with root package name */
    private final AdSessionConfiguration f33462b;

    /* renamed from: c, reason: collision with root package name */
    private final f f33463c;

    /* renamed from: d, reason: collision with root package name */
    private com.iab.omid.library.bytedance2.weakreference.a f33464d;

    /* renamed from: e, reason: collision with root package name */
    private AdSessionStatePublisher f33465e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f33466f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f33467g;

    /* renamed from: h, reason: collision with root package name */
    private final String f33468h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f33469i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f33470j;

    /* renamed from: k, reason: collision with root package name */
    private PossibleObstructionListener f33471k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        this(adSessionConfiguration, adSessionContext, UUID.randomUUID().toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext, String str) {
        this.f33463c = new f();
        this.f33466f = false;
        this.f33467g = false;
        this.f33462b = adSessionConfiguration;
        this.f33461a = adSessionContext;
        this.f33468h = str;
        b(null);
        this.f33465e = (adSessionContext.getAdSessionContextType() == AdSessionContextType.HTML || adSessionContext.getAdSessionContextType() == AdSessionContextType.JAVASCRIPT) ? new com.iab.omid.library.bytedance2.publisher.a(str, adSessionContext.getWebView()) : new b(str, adSessionContext.getInjectedResourcesMap(), adSessionContext.getOmidJsScriptContent());
        this.f33465e.i();
        c.c().a(this);
        this.f33465e.a(adSessionConfiguration);
    }

    private void a() {
        if (this.f33469i) {
            throw new IllegalStateException("Impression event can only be sent once");
        }
    }

    private void a(View view) {
        Collection<a> b11 = c.c().b();
        if (b11 == null || b11.isEmpty()) {
            return;
        }
        for (a aVar : b11) {
            if (aVar != this && aVar.c() == view) {
                aVar.f33464d.clear();
            }
        }
    }

    private void b() {
        if (this.f33470j) {
            throw new IllegalStateException("Loaded event can only be sent once");
        }
    }

    private void b(View view) {
        this.f33464d = new com.iab.omid.library.bytedance2.weakreference.a(view);
    }

    public void a(List<com.iab.omid.library.bytedance2.weakreference.a> list) {
        if (e()) {
            ArrayList arrayList = new ArrayList();
            Iterator<com.iab.omid.library.bytedance2.weakreference.a> it = list.iterator();
            while (it.hasNext()) {
                View view = it.next().get();
                if (view != null) {
                    arrayList.add(view);
                }
            }
            this.f33471k.onPossibleObstructionsDetected(this.f33468h, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull JSONObject jSONObject) {
        b();
        getAdSessionStatePublisher().a(jSONObject);
        this.f33470j = true;
    }

    @Override // com.iab.omid.library.bytedance2.adsession.AdSession
    public void addFriendlyObstruction(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str) {
        if (this.f33467g) {
            return;
        }
        this.f33463c.a(view, friendlyObstructionPurpose, str);
    }

    public View c() {
        return this.f33464d.get();
    }

    public List<e> d() {
        return this.f33463c.a();
    }

    public boolean e() {
        return this.f33471k != null;
    }

    @Override // com.iab.omid.library.bytedance2.adsession.AdSession
    public void error(ErrorType errorType, String str) {
        if (this.f33467g) {
            throw new IllegalStateException("AdSession is finished");
        }
        g.a(errorType, "Error type is null");
        g.a(str, "Message is null");
        getAdSessionStatePublisher().a(errorType, str);
    }

    public boolean f() {
        return this.f33466f && !this.f33467g;
    }

    @Override // com.iab.omid.library.bytedance2.adsession.AdSession
    public void finish() {
        if (this.f33467g) {
            return;
        }
        this.f33464d.clear();
        removeAllFriendlyObstructions();
        this.f33467g = true;
        getAdSessionStatePublisher().f();
        c.c().b(this);
        getAdSessionStatePublisher().b();
        this.f33465e = null;
        this.f33471k = null;
    }

    public boolean g() {
        return this.f33467g;
    }

    @Override // com.iab.omid.library.bytedance2.adsession.AdSession
    public String getAdSessionId() {
        return this.f33468h;
    }

    @Override // com.iab.omid.library.bytedance2.adsession.AdSession
    public AdSessionStatePublisher getAdSessionStatePublisher() {
        return this.f33465e;
    }

    public boolean h() {
        return this.f33462b.isNativeImpressionOwner();
    }

    public boolean i() {
        return this.f33462b.isNativeMediaEventsOwner();
    }

    public boolean j() {
        return this.f33466f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k() {
        a();
        getAdSessionStatePublisher().g();
        this.f33469i = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l() {
        b();
        getAdSessionStatePublisher().h();
        this.f33470j = true;
    }

    @Override // com.iab.omid.library.bytedance2.adsession.AdSession
    public void registerAdView(View view) {
        if (this.f33467g) {
            return;
        }
        g.a(view, "AdView is null");
        if (c() == view) {
            return;
        }
        b(view);
        getAdSessionStatePublisher().a();
        a(view);
    }

    @Override // com.iab.omid.library.bytedance2.adsession.AdSession
    public void removeAllFriendlyObstructions() {
        if (this.f33467g) {
            return;
        }
        this.f33463c.b();
    }

    @Override // com.iab.omid.library.bytedance2.adsession.AdSession
    public void removeFriendlyObstruction(View view) {
        if (this.f33467g) {
            return;
        }
        this.f33463c.c(view);
    }

    @Override // com.iab.omid.library.bytedance2.adsession.AdSession
    public void setPossibleObstructionListener(PossibleObstructionListener possibleObstructionListener) {
        this.f33471k = possibleObstructionListener;
    }

    @Override // com.iab.omid.library.bytedance2.adsession.AdSession
    public void start() {
        if (this.f33466f) {
            return;
        }
        this.f33466f = true;
        c.c().c(this);
        this.f33465e.a(i.c().b());
        this.f33465e.a(com.iab.omid.library.bytedance2.internal.a.a().b());
        this.f33465e.a(this, this.f33461a);
    }
}
