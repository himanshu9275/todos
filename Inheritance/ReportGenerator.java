public interface Renderer { void render(Page p); }
public class PdfRenderer implements Renderer { ... }
public class HtmlRenderer implements Renderer { ... }

public class ReportGenerator {
    private final Renderer renderer;
    public ReportGenerator(Renderer r) { this.renderer = r; }
    public void generate(Page p) { renderer.render(p); } // polymorphic call
}
