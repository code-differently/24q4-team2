import React from 'react';
import { motion } from 'framer-motion';
import { useInView } from 'react-intersection-observer';

const ScrollImage = () => {
  const { ref, inView } = useInView({
    triggerOnce: true,  // Trigger animation once when image is in view
    threshold: 0.1,     // Trigger when 10% of the element is in view
  });

  return (
    <motion.img
      ref={ref}
      src="https://reactjs.org/logo-og.png"
      alt="Kitten"
      initial={{ opacity: 0 }}
      animate={{ opacity: inView ? 1 : 0 }}  // Fade in when in view
      transition={{ duration: 1 }}
      style={{ width: '100%', borderRadius: '8px' }}
    />
  );
};

export default ScrollImage;
