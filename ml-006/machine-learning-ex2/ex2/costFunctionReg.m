function [J, grad] = costFunctionReg(theta, X, y, lambda)
%COSTFUNCTIONREG Compute cost and gradient for logistic regression with regularization
%   J = COSTFUNCTIONREG(theta, X, y, lambda) computes the cost of using
%   theta as the parameter for regularized logistic regression and the
%   gradient of the cost w.r.t. to the parameters. 

% Initialize some useful values
m = length(y); % number of training examples

% You need to return the following variables correctly 
J = 0;
grad = zeros(size(theta));



% ====================== YOUR CODE HERE ======================
% Instructions: Compute the cost of a particular choice of theta.
%               You should set J to the cost.
%               Compute the partial derivatives and set grad to the partial
%               derivatives of the cost w.r.t. each parameter in theta
htheta = sigmoid(X * theta);
j1 = -y.*log(htheta);
j2 = -(1-y).*log(1-htheta);
jall = j1 + j2;

thetasq = (theta.*theta);
regsum  = sum(thetasq) - thetasq(1);
regcost = lambda*regsum/(2 * m);

J = sum (jall)/m+regcost;

resdiff =  (htheta - y );
resdiff2 = resdiff.*X;
ressum = sum(resdiff2) /m ;
grad = ressum';








% =============================================================

end
