package c5;

import a5.h1;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;

/* loaded from: classes2.dex */
public class b implements MessageBodyReader, MessageBodyWriter {

    /* renamed from: f, reason: collision with root package name */
    public static final Class[] f17084f = {InputStream.class, Reader.class};

    /* renamed from: g, reason: collision with root package name */
    public static final Class[] f17085g = {InputStream.class, OutputStream.class, Writer.class, StreamingOutput.class, Response.class};

    /* renamed from: a, reason: collision with root package name */
    protected Charset f17086a = Charset.forName("UTF-8");

    /* renamed from: b, reason: collision with root package name */
    protected SerializerFeature[] f17087b = new SerializerFeature[0];

    /* renamed from: c, reason: collision with root package name */
    protected h1[] f17088c = new h1[0];

    /* renamed from: d, reason: collision with root package name */
    private b5.a f17089d = new b5.a();

    /* renamed from: e, reason: collision with root package name */
    private Class[] f17090e = null;
}
