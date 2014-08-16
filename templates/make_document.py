#!/bin/bash/python
"""Make a document from Markdown using Pandoc

Usage:
  make_document.py MARKDOWN_FILE
  make_document.py [-t | --template TEMPLATE] [-b | --biblio BIB_FILE] MARKDOWN_FILE
  make_document.py (-h | --help)

Arguments:
  MARKDOWN_FILE  A markdown file to convert to latex
  TEMPLATE  A template file to use during the conversion

Examples:
    make_document.py myfile.md
    make_document.py --template template.tex myfile.md

Options:
  -h, --help
  -t, --template

"""
from docopt import docopt
import subprocess
import os

if __name__ == '__main__':
    arguments = docopt(__doc__, version='0.1.0')

    template = '-s'
    if arguments['--template']:
        template = '--template %s' % arguments['TEMPLATE']

    bib_file = ''
    if arguments['BIB_FILE']:
        bib_file = '--biblio %s' %arguments['BIB_FILE']

    file_name = arguments['MARKDOWN_FILE']
    output_name = os.path.splitext(file_name)[0] + '.tex'

    exec_pandoc = 'pandoc %s %s %s -o %s' % (template, bib_file, file_name, output_name)
    subprocess.call(exec_pandoc, shell=True, stdout=subprocess.PIPE)

    exec_latex = '/usr/texbin/pdflatex -synctex=1 -interaction=nonstopmode %s' % (output_name)
    subprocess.call(exec_latex, shell=True, stdout=subprocess.PIPE)
