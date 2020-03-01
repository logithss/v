/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vertex;

/**
 *
 * @author cstuser
 */
public class Line {
    Point p1;
    Point p2;

    public Line() {
    }

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
    
    
    float Det(float a, float b, float c, float d)
	{
		return a * d - b * c;
	}

    
    Point isCrossing(Line l) 
	{
            float x1 = p1.x; float y1 = p1.y;
            float x2 = p2.x; float y2 = p2.y;
            float x3 = l.p1.x; float y3 = l.p1.y;
            float x4 = l.p2.x; float y4 = l.p2.y;
            float ixOut = 0;
            float iyOut = 0;
            
            float detL1 = Det(x1, y1, x2, y2);
            float detL2 = Det(x3, y3, x4, y4);
            float x1mx2 = x1 - x2;
            float x3mx4 = x3 - x4;
            float y1my2 = y1 - y2;
            float y3my4 = y3 - y4;

            float xnom = Det(detL1, x1mx2, detL2, x3mx4);
            float ynom = Det(detL1, y1my2, detL2, y3my4);
            float denom = Det(x1mx2, y1my2, x3mx4, y3my4);
            if (denom == 0.0)//Lines don't seem to cross
            {
                    //System.out.println("NO CROSS");
                    ixOut = -10000000;
                    iyOut = -10000000;
                    return new Point(false);
            }

            ixOut = xnom / denom;
            iyOut = ynom / denom;

            if (verifyBetweenRange(x1, x2, (float)ixOut) &&
                    verifyBetweenRange(x3, x4, (float)ixOut) &&
                    verifyBetweenRange(y1, y2, (float)iyOut) &&
                    verifyBetweenRange(y3, y4, (float)iyOut))
            {


                    if (!Float.isFinite(ixOut) || !Float.isFinite(iyOut)) //Probably a numerical issue
                    {
                            //System.out.println("INF");
                            return new Point(false);
                    }
                    else
                    {
                            //System.out.println("ALL GOOD");
                            return new Point(ixOut, iyOut);
                    }

            }
            else
            {
                    //System.out.println("NOT IN BOUND");
                    return new Point(false);
            }
            
        }


    
    boolean verifyBetweenRange(float i1, float i2, float p)
	{
		float bigI;
		float smallI;
		if (i1 > i2)
		{
			bigI = i1;
			smallI = i2;
		}
		else
		{
			bigI = i2;
			smallI = i1;
		}
		//std::cout << smallI << " " << p << " " << bigI << "\n";
		if (p >= smallI && p <= bigI) {
			return true;
		}
		else { return false; }
	}


}
