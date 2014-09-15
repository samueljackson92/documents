DOCNAME = iy-report.md
OUTPUTFILE = report.tex
BIBFILE = refs.bib

DOCTEMPLATE = ~/git/documents/pipeline/template.tex
BIBSTYLE = ~/git/documents/pipeline/Ieee-with-url.csl
FILTER = ~/git/documents/pipeline/numerical-reference.hs

doc:
	pandoc -f markdown+tex_math_single_backslash --number-sections -t latex --biblio $(BIBFILE) --csl $(BIBSTYLE) --template $(DOCTEMPLATE) $(DOCNAME) -o $(OUTPUTFILE)
	/usr/texbin/pdflatex $(OUTPUTFILE)
