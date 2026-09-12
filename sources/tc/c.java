package tc;

import android.content.Context;
import com.google.firebase.perf.util.i;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import java.net.URI;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class c extends e {

    /* renamed from: c, reason: collision with root package name */
    private static final sc.a f76301c = sc.a.e();

    /* renamed from: a, reason: collision with root package name */
    private final NetworkRequestMetric f76302a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f76303b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NetworkRequestMetric networkRequestMetric, Context context) {
        this.f76303b = context;
        this.f76302a = networkRequestMetric;
    }

    private URI g(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URI.create(str);
        } catch (IllegalArgumentException | IllegalStateException e11) {
            f76301c.k("getResultUrl throws exception %s", e11.getMessage());
            return null;
        }
    }

    private boolean h(URI uri, Context context) {
        if (uri == null) {
            return false;
        }
        return i.a(uri, context);
    }

    private boolean i(String str) {
        if (str == null) {
            return true;
        }
        return str.trim().isEmpty();
    }

    private boolean j(String str) {
        return i(str);
    }

    private boolean k(String str) {
        return (str == null || i(str) || str.length() > 255) ? false : true;
    }

    private boolean m(int i11) {
        return i11 > 0;
    }

    private boolean n(long j11) {
        return j11 >= 0;
    }

    private boolean o(int i11) {
        return i11 == -1 || i11 > 0;
    }

    private boolean p(String str) {
        if (str == null) {
            return false;
        }
        return "http".equalsIgnoreCase(str) || "https".equalsIgnoreCase(str);
    }

    private boolean q(long j11) {
        return j11 >= 0;
    }

    private boolean r(String str) {
        return str == null;
    }

    @Override // tc.e
    public boolean c() {
        if (j(this.f76302a.I())) {
            f76301c.j("URL is missing:" + this.f76302a.I());
            return false;
        }
        URI g11 = g(this.f76302a.I());
        if (g11 == null) {
            f76301c.j("URL cannot be parsed");
            return false;
        }
        if (!h(g11, this.f76303b)) {
            f76301c.j("URL fails allowlist rule: " + g11);
            return false;
        }
        if (!k(g11.getHost())) {
            f76301c.j("URL host is null or invalid");
            return false;
        }
        if (!p(g11.getScheme())) {
            f76301c.j("URL scheme is null or invalid");
            return false;
        }
        if (!r(g11.getUserInfo())) {
            f76301c.j("URL user info is null");
            return false;
        }
        if (!o(g11.getPort())) {
            f76301c.j("URL port is less than or equal to 0");
            return false;
        }
        if (!l(this.f76302a.K() ? this.f76302a.z() : null)) {
            f76301c.j("HTTP Method is null or invalid: " + this.f76302a.z());
            return false;
        }
        if (this.f76302a.L() && !m(this.f76302a.A())) {
            f76301c.j("HTTP ResponseCode is a negative value:" + this.f76302a.A());
            return false;
        }
        if (this.f76302a.M() && !n(this.f76302a.C())) {
            f76301c.j("Request Payload is a negative value:" + this.f76302a.C());
            return false;
        }
        if (this.f76302a.N() && !n(this.f76302a.E())) {
            f76301c.j("Response Payload is a negative value:" + this.f76302a.E());
            return false;
        }
        if (!this.f76302a.J() || this.f76302a.x() <= 0) {
            f76301c.j("Start time of the request is null, or zero, or a negative value:" + this.f76302a.x());
            return false;
        }
        if (this.f76302a.O() && !q(this.f76302a.F())) {
            f76301c.j("Time to complete the request is a negative value:" + this.f76302a.F());
            return false;
        }
        if (this.f76302a.Q() && !q(this.f76302a.H())) {
            f76301c.j("Time from the start of the request to the start of the response is null or a negative value:" + this.f76302a.H());
            return false;
        }
        if (this.f76302a.P() && this.f76302a.G() > 0) {
            if (this.f76302a.L()) {
                return true;
            }
            f76301c.j("Did not receive a HTTP Response Code");
            return false;
        }
        f76301c.j("Time from the start of the request to the end of the response is null, negative or zero:" + this.f76302a.G());
        return false;
    }

    boolean l(NetworkRequestMetric.HttpMethod httpMethod) {
        return (httpMethod == null || httpMethod == NetworkRequestMetric.HttpMethod.HTTP_METHOD_UNKNOWN) ? false : true;
    }
}
