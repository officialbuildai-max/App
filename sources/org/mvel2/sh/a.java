package org.mvel2.sh;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import org.mvel2.ParserContext;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.integration.impl.MapVariableResolverFactory;
import org.mvel2.util.n;
import org.mvel2.util.s;
import q10.c;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: m, reason: collision with root package name */
    private static final String[] f72131m = new String[0];

    /* renamed from: a, reason: collision with root package name */
    private final Map f72132a;

    /* renamed from: b, reason: collision with root package name */
    private Map f72133b;

    /* renamed from: c, reason: collision with root package name */
    private Map f72134c;

    /* renamed from: d, reason: collision with root package name */
    ParserContext f72135d;

    /* renamed from: e, reason: collision with root package name */
    VariableResolverFactory f72136e;

    /* renamed from: f, reason: collision with root package name */
    private int f72137f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f72138g;

    /* renamed from: h, reason: collision with root package name */
    private int f72139h;

    /* renamed from: i, reason: collision with root package name */
    private PrintStream f72140i;

    /* renamed from: j, reason: collision with root package name */
    private String f72141j;

    /* renamed from: k, reason: collision with root package name */
    s f72142k;

    /* renamed from: l, reason: collision with root package name */
    final BufferedReader f72143l;

    /* renamed from: org.mvel2.sh.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0902a {
    }

    public a() {
        HashMap hashMap = new HashMap();
        this.f72132a = hashMap;
        this.f72135d = new ParserContext();
        this.f72138g = false;
        this.f72139h = 0;
        PrintStream printStream = System.out;
        this.f72140i = printStream;
        this.f72142k = new s();
        this.f72143l = new BufferedReader(new InputStreamReader(System.in));
        printStream.println("Starting session...");
        this.f72133b = new HashMap();
        this.f72134c = new HashMap();
        hashMap.putAll(new p10.a().a());
        hashMap.putAll(new c().a());
        this.f72134c.put("$PROMPT", "[@{ new java.text.SimpleDateFormat('hh:mmaa').format(new java.util.Date(System.currentTimeMillis()))}] mvel2$ ");
        this.f72134c.put("$OS_NAME", System.getProperty("os.name"));
        this.f72134c.put("$OS_VERSION", System.getProperty("os.version"));
        this.f72134c.put("$JAVA_VERSION", n.f());
        this.f72134c.put("$CWD", new File(".").getAbsolutePath());
        this.f72134c.put("$COMMAND_PASSTRU", "false");
        this.f72134c.put("$PRINTOUTPUT", "true");
        this.f72134c.put("$ECHO", "false");
        this.f72134c.put("$SHOW_TRACES", "true");
        this.f72134c.put("$USE_OPTIMIZER_ALWAYS", "false");
        this.f72134c.put("$PATH", "");
        try {
            ResourceBundle bundle = ResourceBundle.getBundle(".mvelsh.properties");
            Enumeration<String> keys = bundle.getKeys();
            while (keys.hasMoreElements()) {
                Map map = this.f72134c;
                String nextElement = keys.nextElement();
                map.put(nextElement, bundle.getString(nextElement));
            }
        } catch (MissingResourceException unused) {
            System.out.println("No config file found.  Loading default config.");
            if (!n.a(System.getProperty("os.name").toLowerCase(), "windows")) {
                this.f72134c.put("$PATH", "/bin:/usr/bin:/sbin:/usr/sbin");
            }
        }
        this.f72136e = new MapVariableResolverFactory((Map<String, Object>) this.f72133b, new MapVariableResolverFactory(this.f72134c));
    }

    public String j(int i11) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i12 = 0; i12 < i11; i12++) {
            stringBuffer.append(" ");
        }
        return stringBuffer.toString();
    }
}
