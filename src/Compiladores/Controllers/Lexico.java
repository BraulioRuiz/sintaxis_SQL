/* The following code was generated by JFlex 1.4.3 on 2/12/19 09:43 PM */

package Compiladores.Controllers;
import Controllers.*;
import Controllers.Tokens;
import static Controllers.Tokens.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 2/12/19 09:43 PM from the specification file
 * <tt>C:/Users/JulioCaballero/Documents/GitHub/sintaxis_SQL/src/sintasissql/Lexer.flex</tt>
 */
class Lexico {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\0\1\35\2\0\1\0\22\0\1\13\7\0\1\36\1\36"+
    "\2\0\1\37\1\5\1\0\1\34\12\4\7\0\1\6\1\14\1\16"+
    "\1\15\1\11\1\31\1\33\1\1\1\22\1\1\1\26\1\7\1\24"+
    "\1\20\1\17\1\23\1\30\1\12\1\21\1\10\1\27\2\1\1\32"+
    "\1\25\1\1\1\36\1\0\1\36\1\0\1\2\1\0\32\3\uff85\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\1\1\2\1\3\7\2\1\1"+
    "\2\4\13\2\1\5\1\2\1\6\32\2\1\0\5\2"+
    "\1\0\2\2\1\0\1\2\5\0\1\6";

  private static int [] zzUnpackAction() {
    int [] result = new int[73];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\40\0\100\0\140\0\200\0\140\0\240\0\300"+
    "\0\340\0\u0100\0\u0120\0\u0140\0\u0160\0\u0180\0\40\0\u01a0"+
    "\0\u01c0\0\u01e0\0\u0200\0\u0220\0\u0240\0\u0260\0\u0280\0\u02a0"+
    "\0\u02c0\0\u02e0\0\u0300\0\u0320\0\u0340\0\100\0\u0360\0\u0380"+
    "\0\u03a0\0\u03c0\0\u03e0\0\u0400\0\u0420\0\u0440\0\u0460\0\u0480"+
    "\0\u04a0\0\u04c0\0\u04e0\0\u0500\0\u0520\0\u0540\0\u0560\0\u0580"+
    "\0\u05a0\0\u05c0\0\u05e0\0\u0600\0\u0620\0\u0640\0\u0660\0\u0680"+
    "\0\u06a0\0\u06c0\0\u06e0\0\u0700\0\u0720\0\u0740\0\u0760\0\u0780"+
    "\0\u07a0\0\u07c0\0\u07e0\0\u0800\0\u0820\0\u0840\0\u0860\0\u0880"+
    "\0\40";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[73];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\4\1\7\4\3"+
    "\1\2\2\3\1\10\2\3\1\11\1\12\1\13\3\3"+
    "\1\14\1\3\1\15\2\3\1\16\1\0\1\17\1\20"+
    "\41\0\4\3\1\0\5\3\1\0\20\3\6\0\4\6"+
    "\33\0\1\3\3\5\1\6\5\3\1\0\20\3\5\0"+
    "\4\3\1\0\1\3\1\21\3\3\1\0\1\3\1\22"+
    "\13\3\1\23\2\3\5\0\4\3\1\0\5\3\1\0"+
    "\3\3\1\24\14\3\5\0\4\3\1\0\5\3\1\0"+
    "\7\3\1\25\10\3\5\0\4\3\1\0\5\3\1\0"+
    "\4\3\1\26\13\3\5\0\4\3\1\0\4\3\1\27"+
    "\1\0\20\3\5\0\4\3\1\0\5\3\1\0\4\3"+
    "\1\30\13\3\5\0\4\3\1\0\5\3\1\0\3\3"+
    "\1\31\2\3\1\32\4\3\1\33\4\3\40\0\1\34"+
    "\16\0\1\17\25\0\4\3\1\0\2\3\1\35\2\3"+
    "\1\0\20\3\5\0\4\3\1\0\5\3\1\0\1\3"+
    "\1\36\16\3\5\0\4\3\1\0\2\3\1\37\2\3"+
    "\1\0\20\3\5\0\4\3\1\0\5\3\1\0\4\3"+
    "\1\40\13\3\5\0\4\3\1\0\1\41\4\3\1\0"+
    "\20\3\5\0\4\3\1\0\5\3\1\0\1\3\1\42"+
    "\16\3\5\0\4\3\1\0\5\3\1\0\6\3\1\43"+
    "\11\3\5\0\4\3\1\0\5\3\1\0\6\3\1\44"+
    "\11\3\5\0\4\3\1\0\4\3\1\45\1\0\20\3"+
    "\5\0\4\3\1\0\4\3\1\46\1\0\20\3\5\0"+
    "\4\3\1\0\1\3\1\47\3\3\1\0\20\3\4\0"+
    "\35\34\1\0\2\34\1\0\4\3\1\0\3\3\1\50"+
    "\1\3\1\0\20\3\5\0\4\3\1\0\3\3\1\51"+
    "\1\3\1\0\20\3\5\0\4\3\1\0\5\3\1\0"+
    "\5\3\1\52\12\3\5\0\4\3\1\0\2\3\1\53"+
    "\2\3\1\0\20\3\5\0\4\3\1\0\3\3\1\54"+
    "\1\3\1\0\20\3\5\0\4\3\1\0\5\3\1\0"+
    "\10\3\1\55\7\3\5\0\4\3\1\0\5\3\1\0"+
    "\14\3\1\56\3\3\5\0\4\3\1\0\3\3\1\57"+
    "\1\3\1\0\20\3\5\0\4\3\1\0\5\3\1\0"+
    "\5\3\1\60\12\3\5\0\4\3\1\0\1\3\1\61"+
    "\3\3\1\0\20\3\5\0\4\3\1\0\4\3\1\62"+
    "\1\0\20\3\5\0\4\3\1\0\4\3\1\36\1\0"+
    "\20\3\5\0\4\3\1\0\2\3\1\63\2\3\1\0"+
    "\20\3\5\0\4\3\1\0\5\3\1\0\6\3\1\64"+
    "\11\3\5\0\4\3\1\0\5\3\1\0\16\3\1\36"+
    "\1\3\5\0\4\3\1\0\1\65\4\3\1\0\20\3"+
    "\5\0\4\3\1\0\5\3\1\0\13\3\1\66\4\3"+
    "\5\0\4\3\1\0\5\3\1\0\6\3\1\67\11\3"+
    "\5\0\4\3\1\0\2\3\1\36\2\3\1\0\20\3"+
    "\5\0\4\3\1\0\2\3\1\70\2\3\1\0\20\3"+
    "\5\0\4\3\1\0\5\3\1\71\20\3\5\0\4\3"+
    "\1\0\4\3\1\72\1\0\20\3\5\0\4\3\1\0"+
    "\1\73\4\3\1\0\20\3\5\0\4\3\1\0\4\3"+
    "\1\74\1\0\20\3\5\0\4\3\1\0\3\3\1\36"+
    "\1\3\1\0\20\3\5\0\4\3\1\0\5\3\1\0"+
    "\4\3\1\75\13\3\5\0\4\3\1\0\3\3\1\76"+
    "\1\3\1\0\20\3\14\0\1\77\30\0\4\3\1\0"+
    "\1\100\4\3\1\0\20\3\5\0\4\3\1\0\1\3"+
    "\1\36\3\3\1\0\20\3\5\0\4\3\1\0\5\3"+
    "\1\0\11\3\1\101\6\3\5\0\4\3\1\0\5\3"+
    "\1\0\17\3\1\101\5\0\4\3\1\0\5\3\1\0"+
    "\16\3\1\60\1\3\12\0\1\102\32\0\4\3\1\0"+
    "\5\3\1\0\6\3\1\103\11\3\5\0\4\3\1\0"+
    "\5\3\1\104\20\3\20\0\1\105\24\0\4\3\1\0"+
    "\5\3\1\0\4\3\1\60\13\3\32\0\1\106\20\0"+
    "\1\107\41\0\1\110\37\0\1\111\53\0\1\111\12\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[2208];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\14\1\1\11\51\1\1\0\5\1\1\0"+
    "\2\1\1\0\1\1\5\0\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[73];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    public String lexeme;


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Lexico(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Lexico(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 100) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Tokens yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 5: 
          { /*Ignore*/
          }
        case 7: break;
        case 2: 
          { lexeme=yytext(); return Caracteres;
          }
        case 8: break;
        case 4: 
          { lexeme=yytext(); return Agrupaciones ;
          }
        case 9: break;
        case 3: 
          { lexeme=yytext(); return CaracteresTable;
          }
        case 10: break;
        case 6: 
          { lexeme=yytext(); return Reservadas;
          }
        case 11: break;
        case 1: 
          { return ERROR;
          }
        case 12: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            return null;
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
