;define sqrt

(defun average(x y) (/ (+ x y) 2))

(defun square(x) (* x x))

(defun esqrt(x)
    
    (defun accurate(guess)
        (< (abs (- (square guess) x)) 0.001))
    
    (defun improve(guess)
        (average guess (/ x guess)))
    
    (defun sqrt-iter(guess)
        (if (accurate guess)
            guess
            (sqrt-iter (improve guess))))
    
    (sqrt-iter 1.0))

(esqrt 2)
