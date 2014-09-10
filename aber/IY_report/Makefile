DOCNAME = iy-report.md
OUTPUTFILE = report.tex
DOCTEMPLATE = ~/git/documents/templates/template.tex
BIBFILE = refs.bib
BIBSTYLE = ~/git/documents/templates/ieee-with-url.csl

doc: iy-report.md
	pandoc -f markdown+tex_math_single_backslash --biblio $(BIBFILE) --csl $(BIBSTYLE) --template $(DOCTEMPLATE) $(DOCNAME) -o $(OUTPUTFILE)
	/usr/texbin/pdflatex $(OUTPUTFILE)
